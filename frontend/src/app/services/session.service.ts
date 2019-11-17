import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private urlBase = 'http://localhost:8080/';
  private allUserNumberUrl = this.urlBase + 'usersnumber';
  private activeSessNumberUrl = this.urlBase + 'activesessnumber';
  private activeSessionUrl = this.urlBase + 'activesession';

  constructor(private httpClient: HttpClient) {
  }

  public getAllUserNumber(): Observable<number> {
    return this.httpClient.get<number>(this.allUserNumberUrl);
  }

  public getLoggedUserNumber(): Observable<number> {
    return this.httpClient.get<number>(this.activeSessNumberUrl);
  }

  public saveSignedUser(email: string) {
    return this.httpClient.post<number>(this.activeSessionUrl, email);
  }
}
