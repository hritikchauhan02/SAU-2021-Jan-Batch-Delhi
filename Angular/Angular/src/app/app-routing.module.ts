import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowUserComponent } from './show-user/show-user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';

const routes: Routes = [
  {
    path: 'show',
    component: ShowUserComponent
  },
  {
    path: 'add',
    component: AddUserComponent
  },
  {
    path: 'edit/:id/:name/:email/:dob/:age/:street/:city/:zipcode',
    component: EditUserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
