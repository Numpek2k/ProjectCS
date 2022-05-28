package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Message.Message;
import com.example.hotdoctors.Message.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController @AllArgsConstructor @RequestMapping("/message")
public class MessageController {

    private final MessageServiceImpl messageServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/message/save").toUriString());
        return ResponseEntity.created(uri).body(messageServiceImpl.saveMessage(message));
    }


    @GetMapping("/get")
    public ResponseEntity<Page<Message>> getAllMessages(Principal user,
                                                        @RequestParam(defaultValue = "0") Integer page,
                                                        @RequestParam Integer targetId) {

        return ResponseEntity.ok().body(messageServiceImpl.getAllMessages(user, page,  targetId));
    }
    @GetMapping("/get/unread")
    public ResponseEntity<List<Message>> getAllUnread(Principal user) {

        return ResponseEntity.ok().body(messageServiceImpl.getAllUnread(user));
    }
    @GetMapping("/get/unread/all")
    public ResponseEntity<List<Message>> getAllUnreadFromChat(Principal user, Integer targetId) {

        return ResponseEntity.ok().body(messageServiceImpl.getAllUnreadFromChat(user, targetId));
    }
}
