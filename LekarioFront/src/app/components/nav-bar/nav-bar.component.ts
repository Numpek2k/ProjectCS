import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {TokenService} from "../../services/token.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(public router: Router,
              public tokenService: TokenService) {
  }

  ngOnInit(): void {
  }


  isShown(): boolean {
    return !(this.router.url === '/login' || this.router.url === '/register');
  }

  logout(): void {
    this.tokenService.logout();
  }

}
