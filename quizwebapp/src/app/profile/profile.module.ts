import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { routing } from './profile.routing'

import { ProfileComponent } from './components/profile/profile.component';
import { RankLevelComponent } from './components/rank-level/rank-level.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  imports: [
    routing,
    CommonModule,
    SharedModule
  ],
  declarations: [ProfileComponent, RankLevelComponent]
})
export class ProfileModule { }
