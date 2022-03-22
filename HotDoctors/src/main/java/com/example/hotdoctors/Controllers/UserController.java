package com.example.hotdoctors.Controllers;


import com.example.hotdoctors.Comment.CommentService;
import com.example.hotdoctors.Schedule.ScheduleService;
import com.example.hotdoctors.Users.users.UserService;
import com.example.hotdoctors.Visit.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ScheduleService scheduleService;
    private final CommentService commentService;
    private final VisitService visitService;

}
