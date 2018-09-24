import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SectionsService {

  constructor(private http: HttpClient) {} 

    getSectionsList (username:string) {
      return this.http.get<any>(`http://localhost:8080/sections/`+username);
    }
}
