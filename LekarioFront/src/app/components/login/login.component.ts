import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {Tokens} from "../../utility/tokens";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              public userService: UserService,
              private router: Router) {
  }

  loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    }
  )

  ngOnInit(): void {
  }

  get email(){
    return this.loginForm.controls['email']
  }

  // get password(){
  //   return this.loginForm
  // }

  onLogin(): void {
    let credentials = this.loginForm.value;
    this.userService.login(credentials.email, credentials.password).subscribe(tokens => this.successfulLogin(tokens));
  }

  successfulLogin(tokens: Tokens) {
    this.userService.setTokens(tokens);
    this.userService.getCurrentUser().subscribe(user => this.userService.user = user);
    this.router.navigate(['/']);
  }
}
