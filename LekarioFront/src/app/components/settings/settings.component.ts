import {Component, OnInit} from '@angular/core';
import {ScheduleService} from 'src/app/services/schedule.service';
import {Schedule} from 'src/app/utility/schedule';
import {User} from 'src/app/utility/user';
import {UserService} from "../../services/user.service";
import {DoctorInfo} from "../../utility/doctorInfo";

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  constructor(private userService: UserService,
              private scheduleService: ScheduleService) {
  }

  currentUser?: User
  userSchedule?: Schedule[]
  monday?: Schedule
  tuesday?: Schedule
  wednesday?: Schedule
  thursday?: Schedule
  friday?: Schedule

  ngOnInit(): void {
    this.userService.getUser().subscribe(user => {
      this.currentUser = user;
      if (!this.currentUser.id)
        return;
      this.scheduleService.get(this.currentUser.id).subscribe(schedule => {
        this.userSchedule = schedule;
        this.monday = this.userSchedule.find((obj) => {
          return obj.day == "MONDAY";
        })
        this.tuesday = this.userSchedule.find((obj) => {
          return obj.day == "TUESDAY";
        })
        this.wednesday = this.userSchedule.find((obj) => {
          return obj.day == "WEDNESDAY";
        })
        this.thursday = this.userSchedule.find((obj) => {
          return obj.day == "THURSDAY";
        })
        this.friday = this.userSchedule.find((obj) => {
          return obj.day == "FRIDAY";
        })
      })


    })
  }

  onButtonUpdate(name: string, surn: string, add: string, desc: string): void {
    if (name)
      this.userService.updateName(name).subscribe();
    if (surn)
      this.userService.updateSurname(surn).subscribe();
    if (add || desc) {
      let dInf: DoctorInfo = {
        description: desc,
        address: add
      }
      this.userService.updateDoctorInfo(dInf).subscribe();
    }
  }

  onButtonSchedule(ms: number, me: number,
                   tus: number, tue: number,
                   ws: number, we: number,
                   ths: number, the: number,
                   fs: number, fe: number): void {
    if(!this.currentUser)
      return
    if(ms || me){
      let day: Schedule = {
        day: "MONDAY", h_end: me, h_start: ms, user: this.currentUser
      }
      this.scheduleService.set(day)
    }
    if(tus || tue){
      let day: Schedule = {
        day: "TUESDAY", h_end: tue, h_start: tus, user: this.currentUser
      }
      this.scheduleService.set(day)
    }
    if(ws || we){
      let day: Schedule = {
        day: "WEDNESDAY", h_end: we, h_start: ws, user: this.currentUser
      }
      this.scheduleService.set(day)
    }
    if(ths || the){
      let day: Schedule = {
        day: "THURSDAY", h_end: the, h_start: ths, user: this.currentUser
      }
      this.scheduleService.set(day)
    }
    if(fs || fe){
      let day: Schedule = {
        day: "FRIDAY", h_end: fe, h_start: fs, user: this.currentUser
      }
      this.scheduleService.set(day)
    }
  }
}
