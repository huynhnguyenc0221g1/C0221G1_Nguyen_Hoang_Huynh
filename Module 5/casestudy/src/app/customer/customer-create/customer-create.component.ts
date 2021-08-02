import { Component, OnInit } from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {NavigationExtras, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customer: any;
  customerTypes: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
    this.customer = new FormGroup( {
      name: new FormControl('' , [Validators.required]),
      type: new FormControl('' , [Validators.required]),
      dateOfBirth: new FormControl('', [])
    });
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  getAllCustomerType() {
    this.customerTypeService.getAll().subscribe(next => {
      this.customerTypes = next;
    });
  }

  create() {
    this.customerService.save(this.customer.value).subscribe();
    const navigationExtras: NavigationExtras = {state: {data: 'success'}};
    this.router.navigate(['/customer/list'], navigationExtras);
  }
}
