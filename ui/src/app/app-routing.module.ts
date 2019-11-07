import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserViewComponent } from './user-view/user-view.component';

const routes: Routes = [
  {
    path: 'user', component: UserComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'users', component: UserViewComponent
  },
  {
    path: '', component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
