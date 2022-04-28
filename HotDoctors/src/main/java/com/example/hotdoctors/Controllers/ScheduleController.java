package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Schedule.ScheduleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor @RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleServiceImpl scheduleServiceImpl;



}
