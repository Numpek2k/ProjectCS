import {Injectable} from '@angular/core';
import {BASE_URL} from "../utility/globals";
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
    let url = BASE_URL + '/find/prof/all';
    return this.http.get<Profession[]>(url);
  }

  addProfessionToDoctor(doctor: number, prof: number): void {
    let url = BASE_URL + '/add/prof';
    let httpParams = new HttpParams()
      .set('userId', doctor)
      .set('profId', prof)
    this.http.patch(url, {}, {params: httpParams})
  }
}
