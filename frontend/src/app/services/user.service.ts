import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/userPage';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public findUserPage(page: string, size: string): Observable<User[]> {
    console.log('DEBUG: findUserPage() page = ' + page + ', size = ' + size);

    const parameters = new HttpParams().set('page', page).set('size', size);

    return this.http.get<User[]>(this.usersUrl, {params: parameters});
  }
}
