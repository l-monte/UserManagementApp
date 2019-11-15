import { UserNumberService } from './../services/user-number.service';
import { User } from './../model/user';
import { UserService } from './../services/user.service';
import { Component, ViewChild, ChangeDetectorRef } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, PageEvent } from '@angular/material';

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

  private allUserNumber = 0;
  private loggedUserNumber = 0;

  displayedColumns = ['name', 'surename', 'email', 'timestamp', 'logged'];

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private userService: UserService,
              private userNumberService: UserNumberService) {
  }

  ngOnInit() {

    this.userNumberService.getAllUserNumber().subscribe(num => {
      this.allUserNumber = num;
    });

    this.userNumberService.getLoggedUserNumber().subscribe(num => {
      this.loggedUserNumber = num;
    });
  }

  getUserData(event: PageEvent) {

    this.userService.findUserPage(String(event.pageIndex), String(event.pageSize)).subscribe(data => {
      this.dataSource = data;
    });
  }

  // tslint:disable-next-line: use-lifecycle-interface
  ngAfterViewInit() {
    console.log('The basic params of paginator are being filled');

    this.userService.findUserPage(String(this.initialPageIndex), String(this.pageSize)).subscribe(data => {
      this.dataSource = data;
    });

    this.paginator.pageIndex = this.initialPageIndex;
    this.paginator.pageSize = this.pageSize;
    this.paginator.length = this.totalLength;
  }
}

