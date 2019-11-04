import { COMPANIES } from './mock-companies';
import { Component, OnInit } from '@angular/core';
import {MatListModule} from '@angular/material/list';
import { Company } from './companies';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.scss']
})
export class CompaniesComponent implements OnInit {

  companies = COMPANIES;
  constructor() { }

  ngOnInit() {
  }

}
