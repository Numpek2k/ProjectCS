package com.example.hotdoctors.Schedule;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    List<Schedule> getSchedule(Integer id, Date from, Date to);

    void setSchedule(Schedule schedule);

    void updateSchedule(Integer id);
}
