import { AuthService } from './services/auth.service';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserViewComponent } from './user-view/user-view.component';

const routes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'users', component: UserViewComponent, canActivate: [AuthService]
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
