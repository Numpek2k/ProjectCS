package com.example.hotdoctors.Schedule;

import com.example.hotdoctors.Users.users.UserRepository;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepo;
    private final UserServiceImpl userService;

    @Override
    public List<Schedule> getSchedule(Integer id) {
        Users u = userService.findUserById(id);
        List<Schedule> schedule = scheduleRepo.getSchedule(u);

        if (schedule.isEmpty()) return schedule = new ArrayList<>();
        else return schedule;
    }

    @Override
    public Schedule setSchedule(Principal user, Schedule schedule) {
        Users u = userService.getCurrentUser(user);
        List<Schedule> scheduleList = getSchedule(u.getId());
        Schedule original = new Schedule();

        boolean exists = false;
        for (Schedule s : scheduleList)
            if (s.getDay() == schedule.getDay()) { exists = true; original = s; break; }

        if (exists) {
            if (schedule.getDay() != null) original.setDay(schedule.getDay());
            if (schedule.getH_start() != null) original.setH_start(schedule.getH_start());
            if (schedule.getH_end() != null) original.setH_end(schedule.getH_end());
        } else original = schedule;

        return scheduleRepo.save(original);
    }
}
