import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';

@Component({
  selector: 'app-create-question-code-block',
  templateUrl: './create-question-code-block.component.html',
  styleUrls: ['./create-question-code-block.component.css']
})
export class CreateQuestionCodeBlockComponent implements OnInit {

  options:any = ['h1']
  questionForm: FormGroup;
  optionsForm: FormGroup;
  blocksCorrectOptions = []

  constructor(private formBuilder: FormBuilder) {
    this.questionForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(16)]],
      statement: ['', [Validators.required, Validators.email]]
      });

    this.optionsForm = new FormGroup({});
  }

  ngOnInit() {
  }

}
