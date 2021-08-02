import { Component, OnInit } from '@angular/core';
import {NavigationExtras, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {Educations} from '../../model/education';
import {EmployeeService} from '../../service/employee.service';
import {EducationService} from '../../service/education.service';
import {PositionService} from '../../service/position.service';
import {Positions} from '../../model/position';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {

  employee: any;
  educations: Educations[] = [];
  positionList: Positions[] = [];

  constructor(private employeeService: EmployeeService,
              private educationService: EducationService,
              private positionService: PositionService,
              private router: Router) {
    this.employee = new FormGroup( {
      name: new FormControl('' , []),
      dateOfBirth: new FormControl('', []),
      education: new FormControl('' , []),
      positions: new FormControl('' , [])
    });
  }

  ngOnInit(): void {
    this.getAllEducation();
    this.getAllPosition();
  }

  getAllEducation() {
    this.educationService.getAll().subscribe(next => {
      this.educations = next;
    });
  }

  getAllPosition() {
    this.positionService.getAll().subscribe(next => {
      this.positionList = next;
    });
  }

  create() {
    this.employeeService.save(this.employee.value).subscribe();
    const navigationExtras: NavigationExtras = {state: {data: 'success'}};
    this.router.navigate(['/employee/list'], navigationExtras);
  }
}
