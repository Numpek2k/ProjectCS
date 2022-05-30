import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  doctors?: User[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUsersByProf('Dentist').subscribe(doctors => this.doctors = doctors); //TODO result of search
  }

}
