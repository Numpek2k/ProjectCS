import {User} from "./user";

export interface Schedule{
  id?: number,
  day?: number, //1-Monday 2-TUESDAY ...
  h_start: number,
  h_end: number,
  user: User
}
