import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EducationService {
  private educationURL = 'http://localhost:3000/educations';
  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.educationURL);
  }
}
