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

    this.userNumberService.saveSignedUser(this.email).subscribe(data => {
      // if (data === false) {
      //   this.errorMessage = 'There is no such email, try once again';
      // } else {
      //   this.errorMessage = '';

      console.log('wyswietlam data po post:' + data);


        this.userNumberService.saveSignedUser(this.email).subscribe((val) => {
          console.log('POST call successful value returned in body', val);
        });

        this.router.navigate(['users']);
      //}
    });
  }
}
