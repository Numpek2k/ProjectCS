import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../utility/user";

@Component({
  selector: 'app-card-holder-home',
  templateUrl: './card-holder-home.component.html',
  styleUrls: ['./card-holder-home.component.css']
})
export class CardHolderHomeComponent implements OnInit {

  @Input() doctor!: User
  constructor() { }

  ngOnInit(): void {
  }

}
