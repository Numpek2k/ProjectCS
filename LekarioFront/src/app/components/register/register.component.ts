import {Component, OnInit} from '@angular/core';
import {UntypedFormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";
import {Router} from "@angular/router";
import {samePasswordValidator} from "../../utility/validatePassword";
import {TokenService} from "../../services/token.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm = this.formBuilder.group({
    name: ['', [Validators.required]],
    surname: ['', Validators.required],
    password: ['', {validators: [Validators.required, Validators.minLength(8)], updateOn: 'blur'}],
    password2: ['', {validators: Validators.required, updateOn: 'blur'}],
    email: ['', {validators: [Validators.email, Validators.required], updateOn: 'blur'}],
    role: ['patient', Validators.required]
  }, {validators: samePasswordValidator});

  userExists = false;

  constructor(private formBuilder: UntypedFormBuilder,
              private userService: UserService,
              private tokenService: TokenService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  get name() {
    return this.registerForm.controls['name']
  }

  get email() {
    return this.registerForm.controls['email']
  }

  get password() {
    return this.registerForm.controls['password']
  }

  get surname(){
    return this.registerForm.controls['surname']
  }
  get role() {
    return this.registerForm.controls['role']
  }

  onRegister(): void {
    let user: User = {
      name: this.name.value,
      surname: this.surname.value,
      password: this.password.value,
      email: this.email.value,
    }
    this.userService.register(user, this.role.value === 'doctor')
      .subscribe({
        next: user => this.successfulRegister(user),
        error: err => this.userExists = true
      });
  }

  successfulRegister(user: User) {
    this.userService.user = user;
    this.userService.login(user.email, this.password.value).subscribe(tokens => this.tokenService.setTokens(tokens))
    this.router.navigate(['/']);
  }
}
