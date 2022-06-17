import {VisitStatus} from "./visitStatus";
import {User} from "./user";

export interface Visit{
  id?: number,
  h_start: number,
  date: string,
  description?: string,
  status?: VisitStatus,
  idDoctor: User,
  idPatient: User
}
