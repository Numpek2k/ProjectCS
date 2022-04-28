package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Message.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor @RequestMapping("/message")
public class MessageController {

    private final MessageServiceImpl messageServiceImpl;

}
