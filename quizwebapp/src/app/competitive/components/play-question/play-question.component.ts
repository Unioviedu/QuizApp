import { Component, OnInit, ViewChild } from '@angular/core';
import { QuestionDirective } from './directives/question.directive';

@Component({
  selector: 'app-play-question',
  templateUrl: './play-question.component.html',
  styleUrls: ['./play-question.component.css']
})
export class PlayQuestionComponent implements OnInit {
  @ViewChild(QuestionDirective) dQuestion: QuestionDirective;

  constructor() { }

  ngOnInit() {
  }

}
