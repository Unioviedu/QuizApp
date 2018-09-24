import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Section } from '../model/section.model';
import {Level } from '../model/level.model';
import { QuestionDuo } from '../../question/model/question-duo';
import { QuestionOptionsComponent } from '../../question/components/question-options/question-options.component';
import { QuestionCodeBlockComponent } from '../../question/components/question-code-block/question-code-block.component';

@Injectable({
  providedIn: 'root'
})
export class SectionsService {
  currentLevel: Level;
  newInfo:any = null;
  
  constructor(private http: HttpClient) {} 

    getSectionsList () {
      return this.http.get<Section[]>(`http://192.168.1.114:8080/sections?username=${ this.getCurrentUser() }`);
    }

    getSection (cod:string) {
      return this.http.get<Section>(`http://192.168.1.114:8080/section/${ cod }?username=${ this.getCurrentUser() }`);
    }

    responseLevel(correctQuestion: number, incorrectQuestion: number) {
      let resultLevel = {
        "username": this.getCurrentUser(),
        "codLevel": this.getCurrentLevel().codLevel,
        "codSection": this.getCurrentLevel().codSection,
        "numCorrectQuestion": correctQuestion,
        "numIncorrectQuestion": incorrectQuestion,
        "nextLevels": this.getCurrentLevel().nextLevels
      }

      return this.http.post<any>("http://192.168.1.114:8080/responseLevel", resultLevel);
    }
  
    getQuestionsDuo() {
      var qDuos: QuestionDuo[] = [];

      let cont = 0;
      for (let question of this.currentLevel.questions.sort( (a,b) => a.title.localeCompare(b.title) )) {
        question.isLast = cont == this.currentLevel.questions.length-1;
        let qDuo: QuestionDuo;
        if (question.type == "option")
          qDuo = new QuestionDuo(QuestionOptionsComponent, question);
        else if (question.type == "codeBlock")
          qDuo = new QuestionDuo(QuestionCodeBlockComponent, question);
        qDuos.push(qDuo);
        cont++;
      }
      
      return qDuos;
    }

    changeInfo(newInfo) {
      this.newInfo = newInfo;
    }

    getCurrentUser() {
      return JSON.parse(localStorage.getItem('currentUser')).username;
    }

    setCurrentLevel(level: Level) {
      this.currentLevel = level;
    }

    getCurrentLevel() {
      return this.currentLevel;
    }
}
