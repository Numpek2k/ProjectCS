package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Schedule.Schedule;
import com.example.hotdoctors.Schedule.ScheduleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController @AllArgsConstructor @RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleServiceImpl scheduleServiceImpl;

    @GetMapping("/get")
    public ResponseEntity<List<Schedule>> getSchedule(Integer id) {
        return ResponseEntity.ok().body(scheduleServiceImpl.getSchedule(id));
    }

    @PostMapping("/set")
    public ResponseEntity<Schedule> setSchedule(Principal user, @RequestBody Schedule schedule) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/schedule/set").toUriString());
        return ResponseEntity.created(uri).body(scheduleServiceImpl.setSchedule(user, schedule));
    }
}
