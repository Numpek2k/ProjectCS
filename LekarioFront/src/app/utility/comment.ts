import {User} from "./user";

export interface Comment{
  id?: number
  content: string
  rating: number
  date?: string
  idDoctor: User
  idPatient: User
}
