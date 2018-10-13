import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompetitiveService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = environment.baseUrl;
  }

  createNewQuestion(newQuestion: any) {
    let customQuestion : any = {
        'username': this.getCurrentUser(),
        'question': newQuestion
    };

    return this.http.post<any>(`${this.url}/newQuestion`, customQuestion);
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('currentUser')).username;
  }

    
}