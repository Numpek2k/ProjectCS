import {User} from "./user";

export interface Schedule{
  id?: number,
  day?: string, //0-Monday 1-TUESDAY ...
  h_start: number,
  h_end: number,
  user: User
}
