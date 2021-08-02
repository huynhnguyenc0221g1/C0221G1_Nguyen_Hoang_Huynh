import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {FormControl, FormGroup} from '@angular/forms';
import {Educations} from '../../model/education';
import {EmployeeService} from '../../service/employee.service';
import {EducationService} from '../../service/education.service';
import {PositionService} from '../../service/position.service';
import {Positions} from '../../model/position';

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {
  productForm: any;
  educations: Educations[] = [];
  positionList: Positions[] = [];
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  constructor(@Inject(MAT_DIALOG_DATA) public data, private employeeService: EmployeeService,
              private educationService: EducationService, private positionService: PositionService) {
    this.productForm = new FormGroup ({
      id: new FormControl(this.data.id),
      name: new FormControl(this.data.name),
      dateOfBirth: new FormControl(this.data.dateOfBirth),
      education: new FormControl(this.data.education),
      positions: new FormControl(this.data.positions)
    });
  }

  ngOnInit(): void {
    this.educationService.getAll().subscribe(next => {
      this.educations = next;
    });
    this.positionService.getAll().subscribe(next => {
      this.positionList = next;
    });
  }

  submit() {
    this.employeeService.update(this.productForm.value).subscribe();
  }
}
