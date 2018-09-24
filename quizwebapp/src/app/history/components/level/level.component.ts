import { Component, OnInit, ViewChild, ComponentFactoryResolver, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { QuestionDirective } from './directives/question.directive';
import { SectionsService } from '../../services/sections.service';
import { QuestionDuo } from '../../../question/model/question-duo';
import { Router } from '../../../../../node_modules/@angular/router';

@Component({
  selector: 'app-level',
  templateUrl: './level.component.html',
  styleUrls: ['./level.component.css']
})
export class LevelComponent implements AfterViewInit, OnInit {
  @ViewChild(QuestionDirective) dQuestion: QuestionDirective;
  index: number = 0;
  qDuos: QuestionDuo[];
  alertType: string = null;

  questions: number;
  correctQuestion: number = 0;
  incorrectQuestion: number = 0;
  progressCorrect: string = "0%";
  progressIncorrect: string = "0%";

  constructor(private componentFactoryResolver: ComponentFactoryResolver,
    private cdr: ChangeDetectorRef,
    private sectionService: SectionsService,
    private router: Router) {
  }

  ngOnInit() {
    this.loadLevel();
  }

  ngAfterViewInit() {
    this.loadQuestion();
    this.cdr.detectChanges();
  }

  loadLevel() {
    this.qDuos = this.sectionService.getQuestionsDuo();
    this.questions = this.qDuos.length;
  }

  loadQuestion() {
    let qDuo = this.qDuos[this.index];

    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(qDuo.component);
    const viewContainerRef = this.dQuestion.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent(componentFactory);
    (<any>componentRef.instance).data = qDuo.data;

    <any>componentRef.instance.responseQuestionEvent.subscribe(($event) => this.responseQuestion($event));
    <any>componentRef.instance.nextQuestionEvent.subscribe(($event) => this.nextQuestion($event));
  }

  responseQuestion(isCorrect: boolean) {
    if (isCorrect) {
      this.correctQuestion++;
      this.alertType = "correct";
      let percentajeCorrect = (this.correctQuestion / this.questions) * 100;
      this.progressCorrect = percentajeCorrect.toString() + "%";
    } else {
      this.incorrectQuestion++;
      this.alertType = "incorrect";
      let percentajeIncorrect = (this.incorrectQuestion / this.questions) * 100;
      this.progressIncorrect = percentajeIncorrect.toString() + "%";
    }
  }

  nextQuestion(isLast: boolean) {
    if (isLast) {
      this.sectionService.responseLevel(this.correctQuestion, this.incorrectQuestion).subscribe((data) => {
        let codSection = this.sectionService.getCurrentLevel().codSection;
        this.sectionService.changeInfo(data);
        this.router.navigate(['/section', codSection]);
      }
      );
    } else {
      this.index++;
      this.alertType = null;
      this.loadQuestion();
    }
  }

}
