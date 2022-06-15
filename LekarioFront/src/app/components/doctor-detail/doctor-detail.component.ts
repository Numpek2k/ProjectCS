import {Component, OnInit} from '@angular/core';
import {User} from "../../utility/user";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../services/user.service";
import {UntypedFormControl, UntypedFormGroup} from "@angular/forms";
import {Comment} from "../../utility/comment";
import {CommentService} from "../../services/comment.service";

@Component({
  selector: 'app-doctor-detail',
  templateUrl: './doctor-detail.component.html',
  styleUrls: ['./doctor-detail.component.css']
})
export class DoctorDetailComponent implements OnInit {

  doctor?: User;
  comments?: Comment[];
  radioButtons = new UntypedFormGroup({
    state: new UntypedFormControl('info')
  })

  constructor(private route: ActivatedRoute,
              private commentService: CommentService,
              public userService: UserService) { }

  get state(){
    return this.radioButtons.controls['state']
  }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if(id === null) throw Error('id should be a number');
    this.userService.getUserById(parseInt(id)).subscribe(doc => this.doctor = doc);
    this.commentService.getCommentsAboutDoctor(parseInt(id)).subscribe(comments => this.comments = comments);
  }


}
