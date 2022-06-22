import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
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
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CommentHolderComponent } from './components/comment-holder/comment-holder.component';
import { ChatComponent } from './components/chat/chat.component';
import {NgxPrettyDateModule} from "ngx-pretty-date";
import { MessagesComponent } from './components/messages/messages.component';
import { ScheduleComponent } from './components/schedule/schedule.component';
import { SettingsComponent } from './components/settings/settings.component';
import { AppointmentsComponent } from './components/appointments/appointments.component';

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
    CommentHolderComponent,
    ChatComponent,
    MessagesComponent,
    ScheduleComponent,
    SettingsComponent,
    AppointmentsComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        NgxPrettyDateModule,
        FormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
