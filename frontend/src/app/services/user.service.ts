import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private urlBase = 'http://localhost:8080/';
  private usersUrl = this.urlBase + 'userPage';
  private validateUserUrl = this.urlBase + 'validateuser';

  constructor(private http: HttpClient) {
  }

  public findUserPage(page: string, size: string): Observable<User[]> {

    const params = new HttpParams().append('page', page).append('size', size);

    return this.http.get<User[]>(this.usersUrl, {params});
  }

  public isUserInDB(email: string): Observable<boolean> {

    const params = new HttpParams().append('email', email);

    return this.http.get<boolean>(this.validateUserUrl, {params});
  }
}
