import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  doctors: User[]

  constructor(public userService: UserService) {
    let doc: User = {
      name: 'Unknown',
      surname: 'Doctor',
      email: 'asas@gmail.com',
      doctorInfo: {
        id: 1,
        professionList: [''],
        description: 'hakuna matata',
        imagePath: '',
        address: ''
      }
    }
    this.doctors = [doc, doc, doc, doc, doc]
  }

  ngOnInit(): void {
    this.userService.getUserById(1).subscribe(console.log)
  }


}
