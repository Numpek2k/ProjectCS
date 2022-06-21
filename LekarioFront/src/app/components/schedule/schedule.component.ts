import {Component, Input, OnInit} from '@angular/core';
import {Schedule} from "../../utility/schedule";
import {ScheduleService} from "../../services/schedule.service";
import {ActivatedRoute} from "@angular/router";
import {Visit} from "../../utility/visit";
import {VisitService} from "../../services/visit.service";
import {UserService} from "../../services/user.service";
import {formatDate} from "@angular/common";

interface Hours {
  h: number;
  available: boolean;
}

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  constructor(private scheduleService: ScheduleService,
              private route: ActivatedRoute,
              private visitService: VisitService,
              private userService: UserService,
  ) {
  }


  @Input() date: any;
  @Input() id: any;
  doctorSchedule?: Schedule[];
  schedule?: Schedule;
  dayOfWeek: any;
  hours?: Hours[];
  doctorVisits?: Visit[];
  todayVisits?: Visit[]
  days = ['SUNDAY', 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY']

  ngOnInit(): void {
    this.scheduleService.get(this.id).subscribe(doctorSchedule => {
      this.doctorSchedule = doctorSchedule;
      this.dayOfWeek = this.days [new Date(this.date).getDay()];
      this.schedule = this.doctorSchedule?.find((obj) => {
        return obj.day == this.dayOfWeek;
      });
      if (!this.schedule)
        return;
      let ho = [];
      for (let i = this.schedule?.h_start; i < this.schedule?.h_end; i++) {
        let o = {h: i, available: true};
        ho.push(o);
        o = {h: i, available: true};
      }
      this.hours = ho;
      this.visitService.getDoctorVisit(this.id).subscribe(visits => {
        this.doctorVisits = visits;
        this.todayVisits = this.doctorVisits.filter((obj) => {
          return obj.date == this.date
        });
        if (!this.hours)
          return;
        for (let visit of this.todayVisits) {
          let objId = this.hours.findIndex(obj => obj.h == visit.h_start);
          this.hours[objId].available = false;
        }
      })
    })
  }

  ngOnChanges(): void {
    this.dayOfWeek = this.days [new Date(this.date).getDay()];
    this.schedule = this.doctorSchedule?.find((obj) => {
      return obj.day == this.dayOfWeek;
    });

    this.dayOfWeek = this.days [new Date(this.date).getDay()];
    this.schedule = this.doctorSchedule?.find((obj) => {
      return obj.day == this.dayOfWeek;
    });
    if (!this.schedule)
      return;
    let ho = [];
    for (let i = this.schedule?.h_start; i < this.schedule?.h_end; i++) {
      let o = {h: i, available: true};
      ho.push(o);
      o = {h: i, available: true};
    }
    this.hours = ho;
    this.visitService.getDoctorVisit(this.id).subscribe(visits => {
      this.doctorVisits = visits;
      this.todayVisits = this.doctorVisits.filter((obj) => {
        return obj.date == this.date
      });
      if (!this.hours)
        return;
      for (let visit of this.todayVisits) {
        let objId = this.hours.findIndex(obj => obj.h == visit.h_start);
        this.hours[objId].available = false;
      }
    })
  }

  onButtonAddVisit(hour: number) {
    this.userService.getUser().subscribe(user => {
      if(!this.schedule)
        return;
      let d = formatDate(new Date(this.date), 'yyyy-MM-dd','en_US')
      let visit: Visit = {
        date: d,
        h_start: hour,
        idDoctor: this.schedule.user,
        idPatient: user
      }
      this.visitService.register(visit);

    })
  }
}
