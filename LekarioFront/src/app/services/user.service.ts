import {Injectable} from '@angular/core';
import {User} from "../utility/user";
import {BaseUrlService} from "./base-url.service";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Tokens} from "../utility/tokens";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user?: User;
  tokens?: Tokens;

  constructor(private baseUrl: BaseUrlService,
              private http: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    let url = this.baseUrl.url + '/find/user/all/';

    return this.http.get<User[]>(url);
  }

  login(email: string, password: string): Observable<any> {
    let url = this.baseUrl.url + '/login';

    const body = new HttpParams()
      .set('email', email)
      .set('password', password);

    return this.http.post<any>(url, body.toString(), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    });
  }

  refresh(): void {
    let url = this.baseUrl.url + '/token/refresh';

    if (this.tokens === undefined) return;
    this.http.get<Tokens>(url, {headers: new HttpHeaders().set('Authorization', this.tokens.refresh_token)})
      .subscribe(tokens => this.tokens = tokens);
  }

  register(user: User): Observable<User> {
    let url = this.baseUrl.url + '/save/user';
    return this.http.post<User>(url, user);
  }

  getUserById(id: number): Observable<User> {
    let url = this.baseUrl.url + '/find/user/id?id=' + id;
    return this.http.get<User>(url);
  }

  getUserByEmail(email: string): Observable<User> {
    let url = this.baseUrl.url + '/find/user/email?email=' + email;
    return this.http.get<User>(url);
  }

  setTokens(tokens: Tokens): void {
    this.tokens = tokens;
  }

  logout(): void {
    this.user = undefined;
    this.tokens = undefined;
  }

}
