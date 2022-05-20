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
  tokens: Tokens;

  constructor(private baseUrl: BaseUrlService,
              private http: HttpClient) {
    this.tokens = new Tokens('', '')
  }

  getAllUsers(): Observable<User[]> {
    let url = this.baseUrl.url + '/find/user/all/';

    return this.http.get<User[]>(url);
  }

  login(email: string, password: string): void { //TODO still doesn't work
    let url = this.baseUrl.url + '/login';
    const body = new HttpParams()
      .set('email', email)
      .set('password', password);
    this.http.post<any>(url, body.toString(), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    }).subscribe(tokens => {
      console.log(tokens);
    });
  }

  refresh(): void {
    let url = this.baseUrl.url + '/token/refresh';
    this.http.get<Tokens>(url, {headers: new HttpHeaders().set('Authorization', this.tokens?.refresh_token)})
      .subscribe(res => {
        this.tokens = res;
        console.log(this.tokens)
      });
  }

  register(user: User): void {
    let url = this.baseUrl.url + '/save/user';
    this.http.post(url, user);
  }

  getUserById(id: number): Observable<User>{
    let url = this.baseUrl.url + '/find/user/id?id=' + id;
    return this.http.get<User>(url);
  }

  getUserByEmail(email: string): Observable<User>{
    let url = this.baseUrl.url + '/find/user/email?email=' + email;
    return this.http.get<User>(url);
  }


}
