import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { routing } from './history.routing';

import { SectionsComponent } from './components/sections/sections.component';
import { SharedModule } from '../shared/shared.module';
import { SectionComponent } from './components/section/section.component';
import { LevelComponent } from './components/level/level.component';
import { QuestionModule } from '../question/question.module';
import { QuestionDirective } from './components/level/directives/question.directive';

@NgModule({
  imports: [
    CommonModule,
    routing,
    SharedModule,
    QuestionModule
  ],
  declarations: [
    SectionsComponent,
    SectionComponent,
    LevelComponent,
    QuestionDirective
  ]
})
export class HistoryModule { }
