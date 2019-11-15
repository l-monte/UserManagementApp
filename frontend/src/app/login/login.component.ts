import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { User } from '../model/user';
import { UserNumberService } from '../services/user-number.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private users: User[] = [];

  constructor(private router: Router,
              private userService: UserService,
              private userNumberService: UserNumberService) {}

  email: string;
  password: string;
  errorMessage: string;

  ngOnInit() {
  }

  login(): void {

    this.userService.isUserInDB(this.email).subscribe(data => {

      if (data === true ) {

      this.userNumberService.saveSignedUser(this.email).subscribe((val) => {
          console.log('POST call successful value returned in body', val);
        });

      this.errorMessage = '';
      this.router.navigate(['users']);

      } else {
        this.errorMessage = 'There is no such email, try once again';
      }
    });
  }
}
