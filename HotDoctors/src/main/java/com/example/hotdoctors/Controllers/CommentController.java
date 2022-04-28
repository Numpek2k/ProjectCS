package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Comment.CommentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor @RequestMapping("/comment")
public class CommentController {

    private final CommentServiceImpl commentServiceImpl;


}
