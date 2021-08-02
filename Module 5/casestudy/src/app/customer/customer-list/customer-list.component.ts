import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';
import {CustomerViewComponent} from '../customer-view/customer-view.component';
import {CustomerUpdateComponent} from '../customer-update/customer-update.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  searchText: any;
  customers: Customer[] = [];
  config: any;
  data = '';

  constructor(public dialog: MatDialog,
              private  customerService: CustomerService,
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
    const dialog = this.dialog.open(CustomerDeleteComponent, {
      height: '250px' , width: '300px',
      data: {id , name}
    });
    dialog.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

  openDialog1(id: any, name: any, dateOfBirth: any, type) {
    const  dialog = this.dialog.open(CustomerViewComponent, {
      height: '350px' , width: '450px' ,
      data: {id , name , dateOfBirth, type}
    });
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
  getAll() {
    this.customerService.getAll().subscribe(next => {
      this.customers = next;
    });
  }

  openEditDialog(id, name, dateOfBirth, type) {
    const dialog = this.dialog.open(CustomerUpdateComponent, {
      height: '450px', width: '450px', data: {id, name, dateOfBirth, type}
    });
    dialog.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

  search() {
  }
}
