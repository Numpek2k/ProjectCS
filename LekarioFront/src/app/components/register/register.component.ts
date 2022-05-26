import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {User} from "../../utility/user";
import {Router} from "@angular/router";
import {samePasswordValidator} from "../../utility/validatePassword";

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
  }, {validators: samePasswordValidator})

  constructor(private formBuilder: FormBuilder,
              private userService: UserService,
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
      .subscribe(user => this.successfulRegister(user));
  }

  successfulRegister(user: User) {
    this.userService.user = user;
    this.userService.login(user.email, this.password.value).subscribe(tokens => this.userService.setTokens(tokens))
    this.router.navigate(['/']);
  }
}
