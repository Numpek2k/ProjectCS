import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import { MessageService } from 'src/app/services/message.service';
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private userService: UserService,
              private messageService: MessageService,
  ) { }

  correspondents?: User[]
  id: any


  ngOnInit(): void {
    this.messageService.getCorrespondents().subscribe(correspondents => {
      this.correspondents = correspondents
      this.id = correspondents[0].id
    })
  }

  onButtonClick(idUser: any): void {
    this.id = idUser
  }

}
