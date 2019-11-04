import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompaniesComponent } from './companies/companies/companies.component';
import { CompanyDetailsComponent } from './company-details/company-details.component';
import { MatListModule } from '@angular/material';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { MaterialModule } from './core/material.module';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    CompanyDetailsComponent,
    LoginComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatListModule,
    AppRoutingModule,
    FormsModule,
    MaterialModule
  ],
  exports: [
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
