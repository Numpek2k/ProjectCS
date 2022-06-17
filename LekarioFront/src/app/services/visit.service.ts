import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {TokenService} from "./token.service";
import {BASE_URL} from "../utility/globals";
import {Observable} from "rxjs";
import {Visit} from "../utility/visit";

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  constructor(private http: HttpClient,
              private token: TokenService) { }

  getDoctorVisit(id: number, start: string, end: string): Observable<Visit[]>{
    let url = BASE_URL + '/visit/get/all'
    let params = new HttpParams()
      .set('id', id)
      .set('start', start)
      .set('end', end);
    return this.http.get<Visit[]>(url,{
      params: params
    });
  }

}
