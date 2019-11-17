import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ActiveUserService {

  private activeUserEmail: string;

  constructor() { }

  setActiveUser(email: string) {
    this.activeUserEmail = email;
  }

  getActiveUser(): string {
    return this.activeUserEmail;
  }

  resetActiveUser() {
    this.activeUserEmail = '';
  }
}
