import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private users: User[] = [];

  constructor(private router: Router,
              private userService: UserService) {}

  email: string;
  password: string;
  errorMessage: string;

  ngOnInit() {
  }

  login(): void {
    console.log("email = " + this.email + ", password: " + this.password);

    this.userService.findAll().subscribe(users => {
        this.users = users;
        console.log('Otrzymane dane rozmiar: ' + users.length);

        this.validateUserEmail();
      });
  }

  validateUserEmail() {
    for (let i = 0; i < this.users.length; i++) {
      console.log('iteration for i = ' + i + '. User email: ' + this.users[i].email);
      if (this.users[i].email === this.email) {

        this.errorMessage = '';
        this.router.navigate(['users']);
        break;
      }
    }
    this.errorMessage = 'There is no such email, try once again';
  }

}
