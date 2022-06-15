import { Injectable } from '@angular/core';
import {BASE_URL} from "../utility/globals";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../utility/comment";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  getNewestComments(): Observable<Comment[]>{
    let url = BASE_URL + '/comment/newest';
    return this.http.get<Comment[]>(url);
  }

  addComment(comment: Comment): void{
    let url = BASE_URL + '/comment/add';
    this.http.post(url, comment).subscribe();
  }

  getCommentsAboutDoctor(id: number): Observable<Comment[]>{
    let url = BASE_URL + '/comment/addressee';
    let httpParams = new HttpParams()
      .set('id', id);
    return this.http.get<Comment[]>(url, {params: httpParams})
  }
}
