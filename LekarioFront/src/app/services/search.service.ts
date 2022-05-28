import {Injectable} from '@angular/core';
import {baseUrl} from "../utility/globals";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Profession} from "../utility/profession";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) {
  }

  getAllDoctorsProfessions(): Observable<Profession[]> {
    let url = baseUrl + '/find/prof/all';
    return this.http.get<Profession[]>(url);
  }

  addProfessionToDoctor(doctor: number, prof: number): void {
    let url = baseUrl + '/add/prof';
    let httpParams = new HttpParams()
      .set('userId', doctor)
      .set('profId', prof)
    this.http.patch(url, {}, {params: httpParams})
  }
}
