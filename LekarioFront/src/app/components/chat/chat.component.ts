import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import { MessageService } from 'src/app/services/message.service';
import {UserService} from "../../services/user.service";
import {Message} from "../../utility/message";
import {Router} from "@angular/router";

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

  messageForm = this.formBuilder.group({
    content:['',Validators.required],
    target:['',Validators.required]
  })

  ngOnInit(): void {
  }

  onSendMessage(id: any): void {
    let content = this.messageForm.controls['content'].value;
    if(!content)
      return;

    let message: Message = {
      content: content
    }
    this.messageService.send(message,id);
    window.location.reload();
  }

}
