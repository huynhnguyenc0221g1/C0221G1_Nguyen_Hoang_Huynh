import { Injectable } from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [];
  private customerJsonURL = 'http://localhost:3000/customers';
  constructor(private Http: HttpClient) { }
  getAll(): Observable<any> {
    return this.Http.get(this.customerJsonURL);
  }
  save(customer): Observable<any> {
    return this.Http.post(this.customerJsonURL, customer);
  }
  delete(id: string): Observable<any> {
    return this.Http.delete(`${this.customerJsonURL}/${id}`);
  }
  update(customer): Observable<any> {
    return this.Http.patch(`${this.customerJsonURL}/${customer.id}`, customer);
  }
}
