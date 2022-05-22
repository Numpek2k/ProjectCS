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
    email: ['', {validators: [Validators.email, Validators.required], updateOn: 'blur'}]
  }, {validators: samePasswordValidator, updateOn: "blur"})

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

  onRegister(): void {
    let temp = this.registerForm.value;
    if (temp.password !== temp.password2) return;
    this.registerForm.removeControl('password2')
    this.userService.register(this.registerForm.value as User).subscribe(user => this.successfulRegister(user));
  }

  successfulRegister(user: User) {
    this.userService.user = user;
    this.router.navigate(['/home']);
  }
}
