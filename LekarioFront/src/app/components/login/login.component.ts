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

  incorrectCredentials = false;

  loginForm = this.formBuilder.group({
      email: ['', {validators: [Validators.required, Validators.email], updateOn: 'blur'}],
      password: ['', Validators.required]
    }
  )

  constructor(private formBuilder: FormBuilder,
              public userService: UserService,
              private router: Router) {
  }

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
    this.userService.login(credentials.email, credentials.password).subscribe({
      next: tokens => this.successfulLogin(tokens),
      error: err => {
        if(err.status == 401){
          this.incorrectCredentials = true;
        }
      }
  });
  }

  successfulLogin(tokens: Tokens) {
    this.userService.setTokens(tokens);
    this.userService.getCurrentUser().subscribe(user => this.userService.user = user);
    this.router.navigate(['/']);
  }
}
