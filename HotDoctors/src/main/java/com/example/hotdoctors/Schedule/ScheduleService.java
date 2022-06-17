package com.example.hotdoctors.Schedule;

import com.example.hotdoctors.Users.users.Users;

import java.security.Principal;
import java.util.Date;
import java.util.List;

public interface ScheduleService {

    List<Schedule> getSchedule(Integer id);

    Schedule setSchedule(Principal user, Schedule schedule);
}
