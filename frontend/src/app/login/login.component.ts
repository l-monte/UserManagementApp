import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

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
    console.log("username = " + this.userName + ", password: " + this.password);
      this.router.navigate(["users"]);
  }

}
