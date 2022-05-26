import {Role} from "./role";
import {DoctorInfo} from "./doctorInfo";

export interface User{
  id?: number;
  name: string;
  surname: string;
  email: string;
  password?: string;
  doctorInfo?: DoctorInfo,
  role?: Role
}
