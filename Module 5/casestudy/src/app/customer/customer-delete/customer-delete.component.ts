import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data, private customerService: CustomerService ) { }

  ngOnInit(): void {
  }

  delete(id: any) {
    this.customerService.delete(id).subscribe();
  }
}
