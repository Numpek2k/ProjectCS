import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {CommentService} from "../../services/comment.service";
import {Comment} from "../../utility/comment";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  comments?: Comment[]

  constructor(public userService: UserService,
              private commentService: CommentService) {
  }

  ngOnInit(): void {
    this.commentService.getNewestComments().subscribe(comments => this.comments = comments);
  }


}
