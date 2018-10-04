import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from '../login/services/auth.guard';
import { CompetitiveHomeComponent } from './components/competitive-home/competitive-home.component';

const appRoutes: Routes = [
    { path: 'competitive', component: CompetitiveHomeComponent, canActivate: [AuthGuard]  }
];

export const routing = RouterModule.forChild(appRoutes);
