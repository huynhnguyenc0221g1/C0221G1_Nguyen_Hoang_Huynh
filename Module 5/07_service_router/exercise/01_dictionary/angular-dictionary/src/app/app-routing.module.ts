import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './dictionary/list/list.component';
import {DetailsComponent} from './dictionary/details/details.component';


const routes: Routes = [
  {
    path: 'dictionary',
    component: ListComponent
  },
  {
    path: 'dictionary/detail/:id',
    component: DetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
