import { COMPANIES } from './../companies/companies/mock-companies';
import { Company } from './../companies/companies/companies';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.scss']
})
export class CompanyDetailsComponent implements OnInit {

  company: Company;
  companies = COMPANIES;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.getCompany();
  }

  getCompany(): void {
    const id = +this.route.snapshot.paramMap.get('id');   // plus zamienia wszystko od razu na liczbe

    this.company = COMPANIES[id];
  }

}
