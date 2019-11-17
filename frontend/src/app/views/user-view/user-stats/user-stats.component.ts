import { Component, OnInit, Input } from '@angular/core';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-user-stats',
  templateUrl: './user-stats.component.html',
  styleUrls: ['./user-stats.component.scss']
})
export class UserStatsComponent implements OnInit {

  @Input()
  // tslint:disable-next-line:no-inferrable-types
  allUsersNum: number = 0;

  @Input()
  // tslint:disable-next-line:no-inferrable-types
  loggedUsersNum: number = 0;

  constructor(private sessionService: SessionService) { }

  ngOnInit() {

    this.sessionService.getAllUserNumber().subscribe(num => {
      this.allUsersNum = num;
    });

    this.sessionService.getLoggedUserNumber().subscribe(num => {
      this.loggedUsersNum = num;
    });
  }

}
