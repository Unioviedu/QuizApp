import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompetitiveHomeComponent } from './components/competitive-home/competitive-home.component';

import { routing } from './competitive.routing';

@NgModule({
  imports: [
    CommonModule,
    routing
  ],
  declarations: [CompetitiveHomeComponent]
})
export class CompetitiveModule { }
