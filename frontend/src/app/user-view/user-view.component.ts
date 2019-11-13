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
  private allUserNumber = 0;
  private loggedUserNumber = 0;

  displayedColumns = ['name', 'surename', 'email', 'timestamp', 'logged'];
  dataSource: MatTableDataSource<User>;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private userService: UserService,
              private userNumberService: UserNumberService,
              private changeDetectorRefs: ChangeDetectorRef) {

    // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(this.users);
  }

  ngOnInit() {

    this.userService.findAll().subscribe(data => {
        console.log('Rozmiar danych w UserView::ngOnInit(): ' + data.length);
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });

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

/** Constants used to fill up our data base. */
const COLORS = ['maroon', 'red', 'orange', 'yellow', 'olive', 'green', 'purple',
  'fuchsia', 'lime', 'teal', 'aqua', 'blue', 'navy', 'black', 'gray'];
const NAMES = ['Maia', 'Asher', 'Olivia', 'Atticus', 'Amelia', 'Jack',
  'Charlotte', 'Theodore', 'Isla', 'Oliver', 'Isabella', 'Jasper',
  'Cora', 'Levi', 'Violet', 'Arthur', 'Mia', 'Thomas', 'Elizabeth'];

