import { Component } from '@angular/core';
import { ExceptionService } from './shared/services/exception.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  status: any;
  subscription: Subscription;
  title = 'quizwebapp';

  constructor(private exceptionService: ExceptionService) {
    this.subscription = this.exceptionService
      .getException()
      .subscribe(status => {
        console.log(status) 
        this.status = status; 
      });
  }
}
