import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;
  private validateUserUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/userPage';
    this.validateUserUrl = 'http://localhost:8080/validateuser';
  }

  public findUserPage(page: string, size: string): Observable<User[]> {

    const params = new HttpParams().append('page', page).append('size', size);

    return this.http.get<User[]>(this.usersUrl, {params});
  }

  public isUserInDB(email: string): Observable<boolean> {
    return this.http.post<boolean>(this.validateUserUrl, email);
  }
}
