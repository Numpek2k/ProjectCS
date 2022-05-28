package com.example.hotdoctors.Schedule;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepo;

    @Override
    public List<Schedule> getSchedule(Integer id, Date from, Date to) {
        return null;
    }

    @Override
    public void setSchedule(Schedule schedule) {

    }

    @Override
    public void updateSchedule(Integer id) {

    }
}
