export interface Message{
  id?: number,
  content: string,
  date?: string,
  read?: boolean,
  idWho?: number,
  idWhom?: number
}
