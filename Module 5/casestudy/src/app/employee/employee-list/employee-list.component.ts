import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {Employee} from '../../model/employee';
import {EmployeeService} from '../../service/employee.service';
import {EmployeeDeleteComponent} from '../employee-delete/employee-delete.component';
import {EmployeeViewComponent} from '../employee-view/employee-view.component';
import {EmployeeUpdateComponent} from '../employee-update/employee-update.component';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  searchText: any;
  employees: Employee[] = [];
  config: any;
  data = '';

  constructor(public dialog: MatDialog,
              private  employeeService: EmployeeService,
              private router: Router) {
    this.config = {
      itemsPerPage: 3,
      currentPage: 1
    };
    const state = this.router.getCurrentNavigation().extras.state as {data: string};
    if (state != null) {
      this.data = state.data;
    }
  }

  ngOnInit(): void {
    this.getAll();
  }

  openDialog(id: any, name: any) {
    const dialog = this.dialog.open(EmployeeDeleteComponent, {
      height: '250px' , width: '300px',
      data: {id , name}
    });
    dialog.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

  openDialog1(id: any, name: any, dateOfBirth: any, education, positions) {
    const  dialog = this.dialog.open(EmployeeViewComponent, {
      height: '450px' , width: '450px' ,
      data: {id , name , dateOfBirth, education, positions}
    });
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
  getAll() {
    this.employeeService.getAll().subscribe(next => {
      this.employees = next;
    });
  }

  openEditDialog(id, name, dateOfBirth, education, positions) {
    const dialog = this.dialog.open(EmployeeUpdateComponent, {
      height: '450px', width: '450px', data: {id, name, dateOfBirth, education, positions}
    });
    dialog.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

  search() {
  }
}
