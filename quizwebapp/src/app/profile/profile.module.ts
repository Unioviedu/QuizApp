import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { routing } from './profile.routing'

import { ProfileComponent } from './components/profile/profile.component';
import { RankLevelComponent } from './components/rank-level/rank-level.component';

@NgModule({
  imports: [
    routing,
    CommonModule
  ],
  declarations: [ProfileComponent, RankLevelComponent]
})
export class ProfileModule { }
