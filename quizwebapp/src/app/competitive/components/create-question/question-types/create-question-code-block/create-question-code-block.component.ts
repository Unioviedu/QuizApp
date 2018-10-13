import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { OptionCodeBlock } from '../model/optionCodeBlock';

@Component({
  selector: 'app-create-question-code-block',
  templateUrl: './create-question-code-block.component.html',
  styleUrls: ['./create-question-code-block.component.css']
})
export class CreateQuestionCodeBlockComponent implements OnInit {
  iconNoCorrectOption = 'fa fa-star-o';
  iconCorrectOption = 'fa fa-star';

  @Output() newQuestionEvent: EventEmitter<any> = new EventEmitter();


  idOption = 0;
  options: OptionCodeBlock[] = [];
  correctOptions: OptionCodeBlock[] = [];
  questionForm: FormGroup;
  optionsForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.questionForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(16)]],
      statement: ['', [Validators.required, Validators.email]]
      });

    const firstOption = new OptionCodeBlock(this.idOption);
    firstOption.icon = this.iconNoCorrectOption;

    this.options.push(firstOption);
    this.optionsForm = this.createForm();
  }

  ngOnInit() {
  }

  convertInCorrect(option) {
    let index = this.correctOptions.indexOf(option);

    if (index === -1) {
      this.correctOptions.push(option);
      const value = this.optionsForm.controls[option.id].value;
      this.optionsForm.controls['correct' + option.id] = new FormControl('', Validators.required);
      this.optionsForm.controls['correct' + option.id].setValue(value);

      index = this.options.indexOf(option);
      this.options[index].icon = this.iconCorrectOption;
    }
  }

  removeOption(option) {
    let index = this.options.indexOf(option);
    this.options.splice(index, 1);
    delete this.optionsForm.controls[option.id];

    index = this.correctOptions.indexOf(option);

    if (index > -1) {
      this.correctOptions.splice(index, 1);
      delete this.optionsForm.controls['correct' + option.id];
    }
  }

  addOption() {
    this.idOption++;
    this.optionsForm.controls[this.idOption] = new FormControl('', Validators.required);
    
    const option = new OptionCodeBlock(this.idOption);
    option.icon = this.iconNoCorrectOption;
    this.options.push(option);
  }

  removeCorrectOption(option) {
    let index = this.correctOptions.indexOf(option);

    this.correctOptions.splice(index, 1);
    delete this.optionsForm.controls['correct' + option.id];

    index = this.options.indexOf(option);
    this.options[index].icon = this.iconNoCorrectOption;
  }

  createForm() {
    const group: any = {};

    this.options.forEach(option => {
      group[option.id] = new FormControl('', Validators.required);
    });

    return new FormGroup(group);
  }

}
