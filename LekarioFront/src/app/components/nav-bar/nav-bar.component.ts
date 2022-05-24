import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  // isLoggedIn = false;

  constructor(public router: Router,
              private userService: UserService) {
  }

  ngOnInit(): void {
  }

  isLoggedIn(): boolean{
    return this.userService.user !== undefined;
  }

  isShown(): boolean {
    return !(this.router.url === '/login' || this.router.url === '/register');
  }

  logout(): void {
    this.userService.logout()
  }

}
