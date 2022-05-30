import { Injectable } from '@angular/core';
import {BASE_URL} from "../utility/globals";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../utility/comment";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  getNewestComments(): Observable<Comment[]>{
    let url = BASE_URL + '/comment/newest'
    return this.http.get<Comment[]>(url);
  }
}
