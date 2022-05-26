import {Role} from "./role";

export interface User{
  id?: number;
  name: string;
  surname: string;
  email: string;
  password?: string;
  doctorInfo?: string,
  role?: Role
}
