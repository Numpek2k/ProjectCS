import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {BASE_URL} from "../utility/globals";
import {Message} from "../utility/message";
import {TokenService} from "./token.service";
import {Observable} from "rxjs";
import {User} from "../utility/user";

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient,
              private token: TokenService) { }

  send(message: Message, target: number): void{
    let url = BASE_URL + '/message/save';
    let params = new HttpParams().set('targetId', target)
    this.http.post(url, message, {
      headers: this.token.getAuthorizationHeader(),
      params: params
    }).subscribe({
      error: err => {
        console.log(err)
      }
    });
  }

  get(target: number, page?: number): Observable<Message[]>{
    let url = BASE_URL + '/message/get';
    let params = new HttpParams().set('targetId', target);
    if(page) params.set('page', page);
    return this.http.get<Message[]>(url,{
      headers: this.token.getAuthorizationHeader(),
      params: params
    })
  }

  getUserUnread(): Observable<Message[]>{
    let url = BASE_URL + '/message/get/unread/all';
    return this.http.get<Message[]>(url, {
      headers: this.token.getAuthorizationHeader()
    })
  }

  getChatUnread(target: number): Observable<Message[]>{
    let url = BASE_URL + '/message/get/unread';
    let params = new HttpParams().set('targetId', target);
    return this.http.get<Message[]>(url, {
      headers: this.token.getAuthorizationHeader(),
      params: params
    })
  }

  getAllMessages(target: number): Observable<Message[]>{
    let url = BASE_URL + '/message/get/usertouser';
    let params = new HttpParams().set('targetId', target);
    return this.http.get<Message[]>(url,{
      headers: this.token.getAuthorizationHeader(),
      params: params
    })
  }

  getCorrespondents(): Observable<User[]>{
    let url = BASE_URL + '/message/get/correspondents';
    return this.http.get<User[]>(url,{
      headers: this.token.getAuthorizationHeader(),
    })
  }
}
