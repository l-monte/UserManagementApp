import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserNumberService {

  private allUserNumberUrl: string;
  private loggedUserNumberUrl: string;

  constructor(private httpClient: HttpClient) {
    this.allUserNumberUrl = 'http://localhost:8080/usersnumber';
    this.loggedUserNumberUrl = 'http://localhost:8080/loggedusersnumber';
  }

  public getAllUserNumber(): Observable<number> {
    console.log('DEBUG: Getting data from localhost:8080/usersnumber ...');
    return this.httpClient.get<number>(this.allUserNumberUrl);
  }

  public getLoggedUserNumber(): Observable<number> {
    console.log('DEBUG: Getting data from localhost:8080/loggedusersnumber ...');
    return this.httpClient.get<number>(this.loggedUserNumberUrl);
  }
}
