import {Component, OnInit} from '@angular/core';
import {User} from "../../utility/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {FormControl, FormGroup, Validators, FormBuilder} from "@angular/forms";
import {Comment} from "../../utility/comment";
import {CommentService} from "../../services/comment.service";
import {RATING_UTILS} from "../../../scripts";

@Component({
  selector: 'app-doctor-detail',
  templateUrl: './doctor-detail.component.html',
  styleUrls: ['./doctor-detail.component.css']
})
export class DoctorDetailComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private commentService: CommentService,
              public userService: UserService,
              private router: Router) {
  }

  doctor?: User;
  comments?: Comment[];
  radioButtons = new FormGroup({
    state: new FormControl('info')
  })
  avgRating: any;

  opinionForm = this.formBuilder.group({
      content: ['', Validators.required],
      rating: ['', Validators.required],
    }
  )

  get state(){
    return this.radioButtons.controls['state']
  }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if (id === null) throw Error('id should be a number');

    this.userService.getUserById(parseInt(id)).subscribe({
      next: doc => this.doctor = doc,
      error: err => {
        this.router.navigate(['/'])
      }
    });
    this.commentService.getCommentsAboutDoctor(parseInt(id)).subscribe(comments => {
      this.comments = comments;
      this.avgRating = RATING_UTILS.convertIntToStars(RATING_UTILS.avgRating(comments))
    });
  }

  onAddOpinion(): void {
    let user = this.userService.user
    if (!user) {
      this.router.navigate(['/login']);
      return;
    }

    if (!this.doctor) {
      return;
    }

    let comment: Comment = {
      content: this.opinionForm.controls['content'].value,
      rating: this.opinionForm.controls['rating'].value,
      idPatient: user,
      idDoctor: this.doctor
    }
    this.commentService.addComment(comment);
  }
}
