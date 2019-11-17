import { Router } from '@angular/router';
import { ActiveUserService } from './../../services/active-user.service';
import { SessionService } from '../../services/session.service';
import { User } from './../../model/user';
import { UserService } from './../../services/user.service';
import { Component, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.scss']
})
export class UserViewComponent {

  private dataSource: User[];
  private initialPageIndex = 0;
  private pageSize = 10;
  private totalLength = 100;

  public displayedColumns = ['name', 'surename', 'email', 'timestamp', 'logged'];

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private router: Router,
              private userService: UserService,
              private sessionService: SessionService,
              private activeUserService: ActiveUserService) {
  }

  getUserData(event: PageEvent) {

    this.userService.findUserPage(String(event.pageIndex), String(event.pageSize)).subscribe(data => {

      this.dataSource = data;
    });
  }

  // tslint:disable-next-line: use-lifecycle-interface
  ngOnInit() {

    this.userService.findUserPage(String(this.initialPageIndex), String(this.pageSize)).subscribe(data => {
      this.dataSource = data;
    });

    this.paginator.pageIndex = this.initialPageIndex;
    this.paginator.pageSize = this.pageSize;
    this.paginator.length = this.totalLength;
  }

  logout() {
    this.sessionService.logoutUser(this.activeUserService.getActiveUser()).subscribe(
      res => { this.activeUserService.resetActiveUser(); this.router.navigate(['login']); },
      err => console.log('[logoutUser] HTTP Error: ', err)
  );
  }
}

