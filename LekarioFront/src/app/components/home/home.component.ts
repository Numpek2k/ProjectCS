import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    // this.userService.login('sjsgdf@o2.pl', 'asuydfu');
    // this.userService.getAllUsers().subscribe(res => console.log(res));
    // this.userService.refresh();
    // let user: User = {
    //   name: 'jdsafgb',
    //   surname: 'asfdsdf',
    //   email: 'sjsgdf@o2.pl',
    //   password: 'asuydfu'
    // }
    // this.userService.register(user);
    // this.userService.getUserById(72).subscribe(console.log);
    //   this.userService.getUserByEmail('asdhfosa@o2.pl').subscribe(console.log);
  }


}
