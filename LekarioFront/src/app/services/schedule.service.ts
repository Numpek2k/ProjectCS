import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {BASE_URL} from "../utility/globals";
import {TokenService} from "./token.service";
import {Schedule} from "../utility/schedule";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient,
              private token: TokenService) {
  }

  //possible but not necessary to subscribe
  set(schedule: Schedule): Observable<Schedule> {
    let url = BASE_URL + 'schedule/set';
    let request = this.http.post<Schedule>(url, schedule, {
      headers: this.token.getAuthorizationHeader()
    });
    request.subscribe();
    return request;
  }

  update(id: number, schedule: Schedule): void {
    let url = BASE_URL + 'schedule/update';
    this.http.patch<Schedule>(url, schedule, {
      headers: this.token.getAuthorizationHeader()
    }).subscribe()
  }

  get(id: number): Observable<Schedule[]> {
    let url = BASE_URL + 'schedule/get';
    return this.http.get<Schedule[]>(url, {
      params: new HttpParams().set('id', id)
    })
  }
}
