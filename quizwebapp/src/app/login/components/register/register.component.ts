import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthenticationService } from '../../services/authentication.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  passwordsForm: FormGroup;
  submitted: boolean;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(16)]],
      mail: ['', [Validators.required, Validators.email]],

      passwords: this.formBuilder.group({
        password: ['', []],
        password2: ['', []],
      }, { validator: [this.passwordConfirmed, this.passFormat] })

    });
  }

  passwordConfirmed(c: AbstractControl): { mismatch: boolean } {
    if (c.get('password').value !== c.get('password2').value) {
      return { mismatch: true };
    }
  }

  passFormat(c: AbstractControl): { passFormat: boolean } {
    let length = c.get('password').value.length;
    if (length < 4 || length > 6)
      return { passFormat: true };
  }

  get f() {
    return this.registerForm.controls;
  }

  register() {
    const me = this;
    this.submitted = true;

    if (this.registerForm.invalid)
      return;


    const newUser = {
      username: this.f.username.value,
      password: this.f.passwords.get('password').value,
      mail: this.f.mail.value
    };

    this.authenticationService.register(newUser).subscribe( data =>
      {
        me.authenticationService.login(data.username, data.password).subscribe(data =>
          this.router.navigate(['/home'])
        );
      }
    );
  }



}
