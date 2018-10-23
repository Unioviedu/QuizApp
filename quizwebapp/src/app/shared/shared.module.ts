import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { routing } from './shared.routing';

import { SectionCardComponent } from './components/section-card/section-card.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LevelCardComponent } from './components/level-card/level-card.component';
import { TrophiesComponent } from './components/trophies/trophies.component';

@NgModule({
  imports: [
    CommonModule,
    routing
  ],
  declarations: [
    SectionCardComponent,
    NavbarComponent,
    LevelCardComponent,
    TrophiesComponent
  ],
  exports: [
    SectionCardComponent,
    NavbarComponent,
    LevelCardComponent,
    TrophiesComponent
  ]
})
export class SharedModule { }
