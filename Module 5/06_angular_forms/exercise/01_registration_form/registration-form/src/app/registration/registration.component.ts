import { Component, OnInit } from '@angular/core';
import {User} from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  formSubmit: any ;
  users: User[] = [];
  countries = ['Vietnam', 'Japan', 'Korea Republic', 'China' , 'Thailand'];
  password: string;
  email: string;
  confirmPassword: string;
  age: number;
  country: string;
  gender: string;
  phone: string;
  constructor() {}

  ngOnInit(): void {
  }

  onSubmit(formSubmit) {
    this.formSubmit = formSubmit;
    this.users.push(this.formSubmit.value);
  }
}
