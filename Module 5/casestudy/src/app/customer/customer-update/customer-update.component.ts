import {Component, Inject, OnInit} from '@angular/core';
import {CustomerType} from '../../model/customer-type';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {CustomerTypeService} from '../../service/customer-type.service';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {
  productForm: any;
  customerTypes: CustomerType[] = [];
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  constructor(@Inject(MAT_DIALOG_DATA) public data, private customerService: CustomerService,
              private customerTypeService: CustomerTypeService) {
    this.productForm = new FormGroup ({
      id: new FormControl(this.data.id),
      name: new FormControl(this.data.name),
      dateOfBirth: new FormControl(this.data.dateOfBirth),
      type: new FormControl(this.data.type),
    });
  }

  ngOnInit(): void {
    this.customerTypeService.getAll().subscribe(next => {
      this.customerTypes = next;
    });
  }

  submit() {
    this.customerService.update(this.productForm.value).subscribe();
  }
}
