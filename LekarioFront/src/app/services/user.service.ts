import {Injectable} from '@angular/core';
import {User} from "../utility/user";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Tokens} from "../utility/tokens";
import {Observable} from "rxjs";
import {baseUrl} from "../utility/globals";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user?: User;
  tokens?: Tokens;

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    let url = baseUrl + '/find/user/all/';

    return this.http.get<User[]>(url);
  }

  login(email: string, password: string): Observable<any> {
    let url = baseUrl + '/login';

    const body = new HttpParams()
      .set('email', email)
      .set('password', password);

    return this.http.post<any>(url, body.toString(), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    });
  }

  refresh(): void {
    let url = baseUrl + '/token/refresh';

    if (this.tokens === undefined) return;
    this.http.get<Tokens>(url, {
      headers: new HttpHeaders()
        .set('Authorization', this.tokens.refresh_token)
    })
      .subscribe(tokens => this.tokens = tokens);
  }

  register(user: User, isDoctor: boolean): Observable<User> {
    let url = baseUrl + '/save/user';
    return this.http.post<User>(url, user, {
      params: new HttpParams().set('isDoctor', isDoctor)
    });
  }

  getUserById(id: number): Observable<User> {
    let url = baseUrl + '/find/user/id';
    return this.http.get<User>(url, {
      params: new HttpParams().set('id', id)
    });
  }

  getUserByEmail(email: string): Observable<User> {
    let url = baseUrl + '/find/user/email';
    return this.http.get<User>(url, {
      params: new HttpParams().set('email', email)
    });
  }

  getCurrentUser(): Observable<User> {
    let url = baseUrl + '/find/user/current';
    if (this.tokens === undefined) throw Error('login first');

    return this.http.get<User>(url, {
      headers: new HttpHeaders()
        .set('Authorization', this.tokens.access_token)
    });
  }

  setTokens(tokens: Tokens): void {
    this.tokens = tokens;
  }

  logout(): void {
    this.user = undefined;
    this.tokens = undefined;
  }

  isLoggedIn(): boolean {
    return this.tokens !== undefined;
  }

}
