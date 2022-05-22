import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Token} from "@angular/compiler";
import {Tokens} from "../utility/tokens";
import {BaseUrlService} from "./base-url.service";
import {Observable} from "rxjs";
import {User} from "../utility/user";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  token?: Tokens;
  constructor(private http: HttpClient,
              private baseUrl: BaseUrlService) {
  }

  login(): void{
    let loginUrl = this.baseUrl.url + "/login";
    // this.http.post<Tokens>(loginUrl);
  }

  getAllUsers(): void{
    let url = this.baseUrl.url + '/find/user/all/';
    console.log(this.http.get<User>(url));
  }
}
