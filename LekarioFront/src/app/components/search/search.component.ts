import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";
import {SearchService} from "../../services/search.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  doctors?: User[];
  question: any

  constructor(private userService: UserService,
              private searchService: SearchService
  ) { }

  ngOnInit(): void {
    this.searchService.currentQ.subscribe(q => {
      this.question = q;
      this.searchService.getAllDoctorsBy(this.question).subscribe(result =>{
        this.doctors = result;
      })
    })
  }

}
