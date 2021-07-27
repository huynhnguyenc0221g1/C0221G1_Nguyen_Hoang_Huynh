import {Component, OnInit} from '@angular/core';
import {User} from "../user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formSubmit: any;
  users: User[] = [];
  email: String;
  password: String;

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit(formSubmit) {
    this.formSubmit = formSubmit;
    console.log(this.formSubmit);
    this.users.push(this.formSubmit.value);
  }

}
