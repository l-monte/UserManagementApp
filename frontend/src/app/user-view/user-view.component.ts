import { UserNumberService } from './../services/user-number.service';
import { User } from './../model/user';
import { UserService } from './../services/user.service';
import { Component, ViewChild, ChangeDetectorRef } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.scss']
})
export class UserViewComponent {

  private users: User[] = [];
  private usersPage: User[] = [];
  private allUserNumber = 0;
  private loggedUserNumber = 0;

  displayedColumns = ['name', 'surename', 'email', 'timestamp', 'logged'];
  dataSource: MatTableDataSource<User>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private userService: UserService,
              private userNumberService: UserNumberService) {

    // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(this.users);
  }

  ngOnInit() {

    console.log('UserViewComponent::ngOnInit()');

    this.userService.findUserPage('0', '8').subscribe(data => {
        this.usersPage = data;

        for (const u of this.usersPage) {
          console.log('User page: ' + u);
        }
    });

    // this.userService.findAll().subscribe(data => {

    //     this.users = data;
    //     for (const user of this.users) {
    //       user.timestampDate = (new Date(user.timestamp)).toLocaleString();
    //     }

    //     this.dataSource = new MatTableDataSource(data);
    //     this.dataSource.paginator = this.paginator;
    //   });

    this.userNumberService.getAllUserNumber().subscribe(num => {
      this.allUserNumber = num;
    });

    this.userNumberService.getLoggedUserNumber().subscribe(num => {
      this.loggedUserNumber = num;
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}

