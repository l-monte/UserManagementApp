import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-user-size',
  templateUrl: './user-size.component.html',
  styleUrls: ['./user-size.component.scss']
})
export class UserSizeComponent implements OnInit {

  @Input()
  // tslint:disable-next-line:no-inferrable-types
  allUsersNum: number = 0;

  @Input()
  // tslint:disable-next-line:no-inferrable-types
  loggedUsersNum: number = 0;

  constructor() { }

  ngOnInit() {
  }

}
