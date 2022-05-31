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
    public List<Schedule> getSchedule(Integer id, Date from, Date to) {
        Users u = userService.findUserById(id);
        List<Schedule> schedule = scheduleRepo.getSchedule(u, from, to);

        if (schedule.isEmpty()) return schedule = new ArrayList<>();
        else return schedule;
    }

    @Override
    public List<Schedule> getSchedule(Integer id) {
        Users u = userService.findUserById(id);
        List<Schedule> schedule = scheduleRepo.findAllByUser(u);
        if (schedule.isEmpty()) return schedule = new ArrayList<>();
        else return schedule;
    }

    @Override
    public Schedule setSchedule(Principal user, Schedule schedule) {
        Users u = userService.getCurrentUser(user);
        List<Schedule> scheduleList = getSchedule(u.getId());
        boolean allowed = true;

        for (Schedule s : scheduleList)
            if (s.getDate().equals(schedule.getDate())) allowed = false;

        if (allowed) return scheduleRepo.save(schedule);
        else return null;
    }

    @Override
    public Schedule updateSchedule(Integer id, Schedule schedule) {
        Schedule original = scheduleRepo.findById(id).orElseThrow();
        original = schedule;
        return scheduleRepo.save(original);
    }
}
