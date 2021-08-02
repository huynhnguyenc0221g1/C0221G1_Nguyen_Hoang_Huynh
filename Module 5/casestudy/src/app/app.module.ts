import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import { CustomerUpdateComponent } from './customer/customer-update/customer-update.component';
import { CustomerDeleteComponent } from './customer/customer-delete/customer-delete.component';
import { CustomerViewComponent } from './customer/customer-view/customer-view.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { EmployeeCreateComponent } from './employee/employee-create/employee-create.component';
import { EmployeeDeleteComponent } from './employee/employee-delete/employee-delete.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeUpdateComponent } from './employee/employee-update/employee-update.component';
import { EmployeeViewComponent } from './employee/employee-view/employee-view.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerCreateComponent,
    CustomerListComponent,
    CustomerUpdateComponent,
    CustomerDeleteComponent,
    CustomerViewComponent,
    NavbarComponent,
    EmployeeCreateComponent,
    EmployeeDeleteComponent,
    EmployeeListComponent,
    EmployeeUpdateComponent,
    EmployeeViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatDialogModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
