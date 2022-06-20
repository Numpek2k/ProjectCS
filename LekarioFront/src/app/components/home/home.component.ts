import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {CommentService} from "../../services/comment.service";
import {Comment} from "../../utility/comment";
import {FormBuilder, Validators} from "@angular/forms";
import {SearchService} from "../../services/search.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  comments?: Comment[]
  searchForm = this.formBuilder.group({
    text: ['', Validators.required]
  })

  constructor(public userService: UserService,
              private commentService: CommentService,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.commentService.getNewestComments().subscribe(comments => this.comments = comments);
  }

  get text(){
    return this.searchForm.controls['text']
  }

  search(){
    this.router.navigate(['/search', {text: this.text.value}])
  }
}
