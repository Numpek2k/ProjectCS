package com.example.hotdoctors.Controllers;


import com.example.hotdoctors.Comment.CommentService;
import com.example.hotdoctors.Schedule.ScheduleService;
import com.example.hotdoctors.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ScheduleService scheduleService;
    private final CommentService commentService;

}
