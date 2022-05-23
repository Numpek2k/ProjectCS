import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  isLoggedIn = true;

  constructor(public router: Router) {
  }

  ngOnInit(): void {
  }

  isShown(): boolean {
    return !(this.router.url === '/login' || this.router.url === '/register');
  }

}
