import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuestionOptionsComponent } from './components/question-options/question-options.component';
import { QuestionCodeBlockComponent } from './components/question-code-block/question-code-block.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [QuestionOptionsComponent, QuestionCodeBlockComponent],
  entryComponents: [QuestionOptionsComponent, QuestionCodeBlockComponent],
  exports: [QuestionOptionsComponent, QuestionCodeBlockComponent]
})
export class QuestionModule { }
