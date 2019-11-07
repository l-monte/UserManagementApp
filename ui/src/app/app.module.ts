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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserViewComponent } from './user-view/user-view.component';
import { UserSizeComponent } from './user-view/user-size/user-size.component';

@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    CompanyDetailsComponent,
    LoginComponent,
    UserComponent,
    UserViewComponent,
    UserSizeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatListModule,
    AppRoutingModule,
    FormsModule,
    MaterialModule,
    ReactiveFormsModule
  ],
  exports: [
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
