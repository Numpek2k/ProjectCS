import {Component, OnInit} from '@angular/core';
import {User} from "../../utility/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {FormControl, FormGroup, Validators, FormBuilder} from "@angular/forms";
import {Comment} from "../../utility/comment";
import {CommentService} from "../../services/comment.service";
import {RATING_UTILS} from "../../../scripts";
import {Message} from "../../utility/message";
import {MessageService} from "../../services/message.service";

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
              public messageService: MessageService,
              private router: Router) {
  }

  doctor?: User;
  comments?: Comment[];
  radioButtons = new FormGroup({
    state: new FormControl('info')
  })
  avgRating: any;
  tomorrow?: any;

  opinionForm = this.formBuilder.group({
      content: ['', Validators.required],
      rating: [1, Validators.required],
    }
  )
  getDate: any;
  id: any;

  get state() {
    return this.radioButtons.controls['state']
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id === null) throw Error('id should be a number');

    this.userService.getUserById(parseInt(this.id)).subscribe({
      next: doc => this.doctor = doc,
      error: err => {
        this.router.navigate(['/'])
      }
    });
    this.commentService.getCommentsAboutDoctor(parseInt(this.id)).subscribe(comments => {
      this.comments = comments;
      this.avgRating = RATING_UTILS.convertIntToStars(RATING_UTILS.avgRating(comments))
    });
    this.tomorrow = new Date();
    let dd = String(this.tomorrow.getDate() + 1).padStart(2, '0');
    let mm = String(this.tomorrow.getMonth() + 1).padStart(2, '0'); //January is 0!
    let yyyy = this.tomorrow.getFullYear();
    this.tomorrow = yyyy + '-' + mm + '-' + dd;
  }

  onAddOpinion(): void {
    let content = this.opinionForm.controls['content'].value;
    let rating = this.opinionForm.controls['rating'].value;
    this.userService.getUser().subscribe(user => {
      if (!this.doctor) {
        return;
      }

      if (!content)
        content = '';

      if (!rating)
        rating = 1;

      let comment: Comment = {
        content: content,
        rating: rating,
        idPatient: user,
        idDoctor: this.doctor
      }
      this.commentService.addComment(comment);
    })

  }

  onButtonSendMessage(message: string): void {
    if(!this.doctor?.id)
      return;
    let mes: Message = {
      content: message
    }
    this.messageService.send(mes, this.doctor?.id);
    window.location.reload();
  }
}
