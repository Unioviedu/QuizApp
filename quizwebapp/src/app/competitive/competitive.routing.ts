import { Routes, RouterModule, CanActivate } from '@angular/router';
import { AuthGuard } from '../login/services/auth.guard';
import { CompetitiveHomeComponent } from './components/competitive-home/competitive-home.component';
import { CreateQuestionComponent } from './components/create-question/create-question.component';

const appRoutes: Routes = [
    { path: 'competitive', component: CompetitiveHomeComponent, canActivate: [AuthGuard]  },
    { path: 'createQuestion', component: CreateQuestionComponent, canActivate: [AuthGuard] }
];

export const routing = RouterModule.forChild(appRoutes);
