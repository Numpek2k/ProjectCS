import {Component, Input, OnInit} from '@angular/core';
import {Message} from "../../utility/message";
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {MessageService} from "../../services/message.service";
import {User} from "../../utility/user";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private userService: UserService,
              private messageService: MessageService,
              ) { }

  @Input() id: any
  messageForm = this.formBuilder.group({
    content:['',Validators.required],
    target:['',Validators.required]
  })
  messages?: Message[];
  loggedIn?: User


  ngOnInit(): void {
    this.userService.getUser().subscribe(loggedIn => this.loggedIn = loggedIn)
    if(!this.loggedIn?.id)
      return;
  }

  ngOnChanges(): void{
    this.userService.getUser().subscribe(loggedIn => this.loggedIn = loggedIn)
    this.messageService.getAllMessages(this.id).subscribe(messages => this.messages = messages)
    if(!this.loggedIn?.id)
      return;
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

  compareUser(log: any,mes: any): boolean{
    return JSON.stringify(log) === JSON.stringify(mes);
  }

}
