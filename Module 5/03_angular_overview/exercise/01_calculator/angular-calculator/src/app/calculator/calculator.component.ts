import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  result : number;
  first : number;
  second : number;

  onFirstChange(value) {
    this.first = Number(value);
  }

  onSecondChange(value) {
    this.second = Number(value);
  }

  plus() {
    this.result = this.first + this.second;
  }

  minus() {
    this.result = this.first - this.second;
  }

  mutiply() {
    this.result = this.first * this.second;
  }

  divide() {
    this.result = this.first / this.second;
  }

}
