import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../utility/user";
import {CommentService} from "../../services/comment.service";
import {Comment} from "../../utility/comment";

@Component({
  selector: 'app-card-holder-search',
  templateUrl: './card-holder-search.component.html',
  styleUrls: ['./card-holder-search.component.css']
})
export class CardHolderSearchComponent implements OnInit {

  @Input() doctor!: User;
  comments?: Comment[];

  constructor(private commentService: CommentService) { }

  ngOnInit(): void {
    if (this.doctor.id != null) {
      this.commentService.getCommentsAboutDoctor(this.doctor.id).subscribe(comments => this.comments = comments)
    }
  }

}
