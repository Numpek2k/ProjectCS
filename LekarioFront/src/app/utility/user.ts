import {Role} from "./role";

export class User{
  id?: number
  name: string
  surname: string
  email: string
  password?: string
  role?: Role


  constructor(name: string, surname: string, email: string, password: string) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }
}
