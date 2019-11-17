import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private urlBase = 'http://localhost:8080/';
  private allUserNumberUrl = this.urlBase + 'usersnumber';
  private loggedUserNumberUrl = this.urlBase + 'loggedusersnumber';
  private postLoggedUserUrl = this.urlBase + 'userlogged';

  constructor(private httpClient: HttpClient) {
  }

  public getAllUserNumber(): Observable<number> {
    return this.httpClient.get<number>(this.allUserNumberUrl);
  }

  public getLoggedUserNumber(): Observable<number> {
    return this.httpClient.get<number>(this.loggedUserNumberUrl);
  }

  public saveSignedUser(email: string) {
    return this.httpClient.post<number>(this.postLoggedUserUrl, email);
  }
}
