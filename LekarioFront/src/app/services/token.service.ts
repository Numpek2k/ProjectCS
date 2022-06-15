import { Injectable } from '@angular/core';
import {Tokens} from "../utility/tokens";
import {PersistenceService} from "angular-persistence";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor(private store: PersistenceService) { }

  setTokens(tokens: Tokens): void{
    this.store.set('tokens', tokens);
  }
}
