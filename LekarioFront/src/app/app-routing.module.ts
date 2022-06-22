import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {DoctorDetailComponent} from "./components/doctor-detail/doctor-detail.component";
import {RegisterComponent} from "./components/register/register.component";
import {HomeComponent} from "./components/home/home.component";
import {SearchComponent} from "./components/search/search.component";
import {ChatComponent} from "./components/chat/chat.component";
import {SettingsComponent} from "./components/settings/settings.component";
import {AppointmentsComponent} from "./components/appointments/appointments.component";

const routes: Routes = [
  {path: 'doctor/:id', component: DoctorDetailComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'search', component: SearchComponent},
  {path: 'chat', component: ChatComponent},
  {path: 'settings', component: SettingsComponent},
  {path: 'appointments', component: AppointmentsComponent},
  {path: '', redirectTo:'/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
