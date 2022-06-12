import {Component, Input, OnInit} from '@angular/core';
import {Comment} from "../../utility/comment";
import {RATING_UTILS} from "../../../scripts";

@Component({
  selector: 'app-comment-holder',
  templateUrl: './comment-holder.component.html',
  styleUrls: ['./comment-holder.component.css']
})
export class CommentHolderComponent implements OnInit {

  @Input() comment!: Comment
  rating: any;
  constructor() { }

  ngOnInit(): void {
    this.rating = RATING_UTILS.convertIntToStars(this.comment.rating);
  }



}
