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

  getDoctorVisit(id: number): Observable<Visit[]>{
    let url = BASE_URL + '/visit/get/all'
    return this.http.get<Visit[]>(url,{
      params: new HttpParams().set('id', id)
    });
  }

  update(visitId: number, visit: Visit): void{
    let url = BASE_URL + '/visit/update';
    this.http.patch(url, visit, {
      params: new HttpParams().set('visitId', visitId),
      headers: this.token.getAuthorizationHeader()
    }).subscribe();
  }

  register(visit: Visit): Observable<Visit>{
    let url = BASE_URL + '/visit/save';
    let request = this.http.post<Visit>(url, visit);
    request.subscribe();
    return request;
  }
}
