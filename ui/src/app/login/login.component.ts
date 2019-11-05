import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  userName: string;
  password: string;

  ngOnInit() {
  }

  login(): void {
    if (this.userName == 'admin' && this.password == 'root') {
      this.router.navigate(["user"]);
    } else {
      alert("Ivalid credentials");
    }
  }

}
