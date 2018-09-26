import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
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
  url: string;
  currentLevel: Level;
  newInfo: any = null;

  constructor(private http: HttpClient) {
    this.url = environment.baseUrl;
  }

    getSectionsList () {
      return this.http.get<Section[]>(`${this.url}/sections?username=${ this.getCurrentUser() }`);
    }

    getSection (cod: string) {
      return this.http.get<Section>(`${this.url}/section/${ cod }?username=${ this.getCurrentUser() }`);
    }

    responseLevel(correctQuestion: number, incorrectQuestion: number) {
      const resultLevel = {
        'username': this.getCurrentUser(),
        'codLevel': this.getCurrentLevel().codLevel,
        'codSection': this.getCurrentLevel().codSection,
        'numCorrectQuestion': correctQuestion,
        'numIncorrectQuestion': incorrectQuestion,
        'nextLevels': this.getCurrentLevel().nextLevels
      };

      return this.http.post<any>(`${this.url}/responseLevel`, resultLevel);
    }

    getQuestionsDuo() {
      const qDuos: QuestionDuo[] = [];

      let cont = 0;
      for (const question of this.currentLevel.questions.sort( (a, b) => a.title.localeCompare(b.title) )) {
        question.isLast = cont === this.currentLevel.questions.length - 1;
        let qDuo: QuestionDuo;
        if (question.type === 'option') {
          qDuo = new QuestionDuo(QuestionOptionsComponent, question);
        } else if (question.type === 'codeBlock') {
          qDuo = new QuestionDuo(QuestionCodeBlockComponent, question);
        }
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
