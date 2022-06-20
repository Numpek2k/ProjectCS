import { Component, OnInit } from '@angular/core';
import {User} from "../../utility/user";
import {SearchService} from "../../services/search.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  doctors?: User[];

  constructor(private searchService: SearchService,
              private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.router.paramMap.subscribe(paramMap => {
      let text = paramMap.get('text');
      if (!text) return;
      this.searchService.getDoctors(text).subscribe(doctors => this.doctors = doctors);
    })
  }

}
