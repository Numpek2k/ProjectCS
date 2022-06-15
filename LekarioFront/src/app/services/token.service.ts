import { Injectable } from '@angular/core';
import {Tokens} from "../utility/tokens";
import jwtDecode from "jwt-decode";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BASE_URL} from "../utility/globals";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor(private http: HttpClient,
              private router: Router) { }

  setTokens(tokens: Tokens): void{
    localStorage.setItem('access_token', tokens.access_token);
    localStorage.setItem('refresh_token', tokens.refresh_token);
  }

  getToken(): string{
    let token = localStorage.getItem('access_token');
    if (!token) throw Error('log in first');
    let exp = jwtDecode<{ [key: string]: string }>(token)['exp']
    if ((parseInt(exp) * 1000) - Date.now() < 500) {
      this.refresh()
    }
    return token;
  }

  refresh(): void {
    let url = BASE_URL + '/token/refresh';
    let token = localStorage.getItem('refresh_token');
    if (!token) return;
    let exp = jwtDecode<{ [key: string]: string }>(token)['exp']
    if ((parseInt(exp) * 1000) - Date.now() < 500) {
      this.router.navigate(['/login']);
    }
    this.http.get<Tokens>(url, {
      headers: new HttpHeaders()
        .set('Authorization', token)
    }).subscribe(tokens => this.setTokens(tokens));
  }

  logout(): void{
    localStorage.clear();
  }

  isLoggedIn(): boolean{
    return this.getToken() !== null;
  }

  getAuthorizationHeader(): HttpHeaders{
    let token = this.getToken();
    return new HttpHeaders().set('Authorization', token)
  }
}
