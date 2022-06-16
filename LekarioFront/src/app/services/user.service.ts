import {Injectable} from '@angular/core';
import {User} from "../utility/user";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Tokens} from "../utility/tokens";
import {Observable, of} from "rxjs";
import {BASE_URL} from "../utility/globals";
import {TokenService} from "./token.service";
import {DoctorInfo} from "../utility/doctorInfo";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user?: User;

  constructor(private http: HttpClient,
              private tokenService: TokenService) {
  }

  getAllUsers(): Observable<User[]> {
    let url = BASE_URL + '/find/user/all/';
    return this.http.get<User[]>(url);
  }

  login(email: string, password: string): Observable<Tokens> {
    let url = BASE_URL + '/login';

    const body = new HttpParams()
      .set('email', email)
      .set('password', password);

    return this.http.post<Tokens>(url, body.toString(), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
    });
  }

  register(user: User, isDoctor: boolean): Observable<User> {
    let url = BASE_URL + '/save/user';
    return this.http.post<User>(url, user, {
      params: new HttpParams().set('isDoctor', isDoctor)
    });
  }

  getUserById(id: number): Observable<User> {
    let url = BASE_URL + '/find/user/id';
    return this.http.get<User>(url, {
      params: new HttpParams().set('id', id)
    });
  }

  getUserByEmail(email: string): Observable<User> {
    let url = BASE_URL + '/find/user/email';
    return this.http.get<User>(url, {
      params: new HttpParams().set('email', email)
    });
  }

  getCurrentUser(): Observable<User> {
    let url = BASE_URL + '/find/user/current';
    let response = this.http.get<User>(url, {
      headers: this.tokenService.getAuthorizationHeader()
    });
    response.subscribe(user => this.setUser(user))
    return response;
  }



  getUsersByProf(prof: string): Observable<User[]>{
    let url = BASE_URL + '/find/user/prof';
    let httpParams = new HttpParams()
      .set('prof', prof);
    return this.http.get<User[]>(url, {params: httpParams});
  }

  updateName(name: string): Observable<any>{
    let  url = BASE_URL + '/user/update/name';
    return this.http.post(url, name, {
      headers: this.tokenService.getAuthorizationHeader()
    });
  }

  updateSurname(surname: string): Observable<any>{
    let  url = BASE_URL + '/user/update/surname';
    return this.http.post(url, surname, {
      headers: this.tokenService.getAuthorizationHeader()
    });
  }

  updatePassword(password: string): Observable<any>{
    let  url = BASE_URL + '/user/update/password';
    return this.http.post(url, password, {
      headers: this.tokenService.getAuthorizationHeader()
    });
  }

  updateDoctorInfo(doctorInfo: DoctorInfo): Observable<any>{
    let  url = BASE_URL + '/user/update/doctorInfo';
    return this.http.post(url, doctorInfo, {
      headers: this.tokenService.getAuthorizationHeader()
    });
  }

  getUser(): Observable<User>{
    if (this.user) {
      return of<User>(this.user).pipe()
    }
    return this.getCurrentUser();
  }

  setUser(user: User): void{
    this.user = user;
  }

}
