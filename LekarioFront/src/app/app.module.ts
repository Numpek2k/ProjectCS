import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {DoctorDetailComponent} from './components/doctor-detail/doctor-detail.component';
import {AppRoutingModule} from './app-routing.module';
import {HomeComponent} from './components/home/home.component';
import {CardHolderHomeComponent} from "./components/card-holder-home/card-holder-home.component";
import { SearchComponent } from './components/search/search.component';
import { CardHolderSearchComponent } from './components/card-holder-search/card-holder-search.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NavBarComponent,
    DoctorDetailComponent,
    HomeComponent,
    CardHolderHomeComponent,
    SearchComponent,
    CardHolderSearchComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
