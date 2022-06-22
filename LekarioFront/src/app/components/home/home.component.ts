import {Component, OnInit} from '@angular/core';
import {CommentService} from "../../services/comment.service";
import {Comment} from "../../utility/comment";
import {SearchService} from "../../services/search.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  comments?: Comment[]

  constructor(private commentService: CommentService,
              private searchService: SearchService,
              private router: Router
              ) {
  }

  ngOnInit(): void {
    this.commentService.getNewestComments().subscribe(comments => this.comments = comments);
  }

  onButtonSetQuestion(q: string): void {
    this.searchService.changeQ(q);
    this.router.navigate(["/search"])
  }

}
