import {Component, Input, OnInit} from '@angular/core';
import {Comment} from "../../utility/comment";

@Component({
  selector: 'app-card-holder-home',
  templateUrl: './card-holder-home.component.html',
  styleUrls: ['./card-holder-home.component.css']
})
export class CardHolderHomeComponent implements OnInit {

  @Input() comment!: Comment
  constructor() { }

  ngOnInit(): void {
  }

}
