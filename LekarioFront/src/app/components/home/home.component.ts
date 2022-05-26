import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  doc: User = {
    name: 'Unknown',
    surname: 'Doctor',
    email: 'asas@gmail.com',
  }
  constructor(public userService: UserService) { }

  ngOnInit(): void {
  }


}
