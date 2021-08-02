import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employees: Employee[] = [];
  private employeeJsonURL = 'http://localhost:3000/employee';
  constructor(private Http: HttpClient) { }
  getAll(): Observable<any> {
    return this.Http.get(this.employeeJsonURL);
  }
  save(employee): Observable<any> {
    return this.Http.post(this.employeeJsonURL, employee);
  }
  delete(id: string): Observable<any> {
    return this.Http.delete(`${this.employeeJsonURL}/${id}`);
  }
  update(employee): Observable<any> {
    return this.Http.patch(`${this.employeeJsonURL}/${employee.id}`, employee);
  }
}
