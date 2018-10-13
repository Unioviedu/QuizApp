import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompetitiveService } from '../../services/competitive.services';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {

  constructor(private router: Router, private service: CompetitiveService) { }

  ngOnInit() {
  }

  newQuestion(newQuestion: any) {
    this.service.createNewQuestion(newQuestion).subscribe();
  }


}
