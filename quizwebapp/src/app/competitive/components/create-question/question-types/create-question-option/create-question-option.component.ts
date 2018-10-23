import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-create-question-option',
  templateUrl: './create-question-option.component.html',
  styleUrls: ['./create-question-option.component.css']
})
export class CreateQuestionOptionComponent implements OnInit {
  @Output() newQuestionEvent: EventEmitter<any> = new EventEmitter();

  questionForm: FormGroup;
  optionsForm: FormGroup;
  options: any = ['option1'];
  index = 1;

  submitted: boolean;

  constructor(private formBuilder: FormBuilder) {

    this.questionForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(16)]],
      statement: ['', [Validators.required]]
      });

      this.optionsForm = this.createForm();
  }

  ngOnInit() {
  }

  addOption() {
    this.index++;
    this.optionsForm.controls['option' + this.index] = new FormControl('', Validators.required);
    this.optionsForm.controls['option' + this.index + 'isCorrect'] = new FormControl('', Validators.required);
    this.options.push('option' + this.index);
  }

  removeOption(option) {
    delete this.optionsForm.controls[option];
    delete this.optionsForm.controls[this.index.toString()];
    this.index--;
    this.options.pop();
  }

  createForm() {
    const group: any = {};

    this.options.forEach(option => {
      group[option] = new FormControl('', Validators.required);
      group[option + 'isCorrect'] = new FormControl('', Validators.required);
    });

    return new FormGroup(group);
  }

  save() {
    this.submitted = true;

    if (this.questionForm.invalid) {
      return;
    }

    const questionForm = this.questionForm.controls;
    const optionsForm = this.optionsForm.controls;

    const optionsObj = [];

    this.options.forEach(
      function (value) {
        const optionObj = {
          'value': optionsForm[value].value,
          'correct': optionsForm[value + 'isCorrect'].value
        };

        optionsObj.push(optionObj);
      }
    );

    const newQuestion = {
      'title': questionForm.title.value,
      'statement': questionForm.statement.value,
      'type': 'option',
      'options': optionsObj
    };

    this.newQuestionEvent.emit(newQuestion);
  }

  get q() {
    return this.questionForm.controls;
  }

}
