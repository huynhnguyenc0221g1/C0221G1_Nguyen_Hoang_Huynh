import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {EmployeeService} from '../../service/employee.service';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data, private employeeService: EmployeeService ) { }

  ngOnInit(): void {
  }

  delete(id: any) {
    this.employeeService.delete(id).subscribe();
  }
}
