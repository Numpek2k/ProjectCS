import {User} from "./user";

export interface Message{
  id?: number,
  content: string,
  date?: string,
  read?: boolean,
  idWho?: User,
  idWhom?: User
}
