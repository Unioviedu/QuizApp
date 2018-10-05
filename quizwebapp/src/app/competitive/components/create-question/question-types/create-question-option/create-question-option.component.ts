import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-create-question-option',
  templateUrl: './create-question-option.component.html',
  styleUrls: ['./create-question-option.component.css']
})
export class CreateQuestionOptionComponent implements OnInit {

  questionForm: FormGroup;
  optionsForm: FormGroup;
  options: any = ['option1'];
  index = 1;

  constructor(private formBuilder: FormBuilder) {

    this.questionForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(16)]],
      statement: ['', [Validators.required, Validators.email]]
      });

      this.optionsForm = this.createForm();
  }

  ngOnInit() {
  }

  addOption() {
    this.index++;
    this.optionsForm.controls['option' + this.index] = new FormControl('', Validators.required);
    this.optionsForm.controls[this.index.toString()] = new FormControl('', Validators.required);
    this.options.push('option' + this.index);
  }

  removeOption() {
    delete this.optionsForm.controls['option' + this.index];
    delete this.optionsForm.controls[this.index.toString()];
    this.index--;
    this.options.pop();
  }

  createForm() {
    const group: any = {};

    this.options.forEach(option => {
      group[option] = new FormControl('', Validators.required);
      group['1'] = new FormControl('', Validators.required);
    });

    return new FormGroup(group);
  }

  save() {
    const questionForm = this.questionForm.controls;
    const optionsForm = this.optionsForm.controls;
    debugger
  }

}
