import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {Tokens} from "../../utility/tokens";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
      email: '',
      password: ''
    }
  )

  constructor(private formBuilder: FormBuilder,
              private userService: UserService) { }

  ngOnInit(): void {
  }

  onLogin(): void{
    this.userService.login(this.loginForm.value.email, this.loginForm.value.password).subscribe(tokens => {
      this.userService.tokens = tokens;
      if (tokens === undefined) console.log('adsfhgi')
      this.userService.getUserByEmail(this.loginForm.value.email);
    });
  }
}
