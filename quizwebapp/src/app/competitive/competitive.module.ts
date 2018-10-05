import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompetitiveHomeComponent } from './components/competitive-home/competitive-home.component';

import { routing } from './competitive.routing';
import { CreateQuestionComponent } from './components/create-question/create-question.component';
import { CreateQuestionOptionComponent } from './components/create-question/question-types/create-question-option/create-question-option.component';
import { CreateQuestionCodeBlockComponent } from './components/create-question/question-types/create-question-code-block/create-question-code-block.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    routing,
    ReactiveFormsModule
  ],
  declarations: [CompetitiveHomeComponent, CreateQuestionComponent, CreateQuestionOptionComponent, CreateQuestionCodeBlockComponent]
})
export class CompetitiveModule { }
