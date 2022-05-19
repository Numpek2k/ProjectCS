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

  login(username: string, password: string): void {
    let url = this.baseUrl.url + '/login';
    const body = new HttpParams()
      .set('username', username)
      .set('password', password);
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
    this.http.post<Tokens>(url, body.toString(), {headers}).subscribe(tokens => {
      this.tokens = tokens;
      console.log(this.tokens);
    });
  }
}
