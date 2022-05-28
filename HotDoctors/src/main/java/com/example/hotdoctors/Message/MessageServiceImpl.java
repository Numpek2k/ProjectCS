package com.example.hotdoctors.Message;


import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor @Slf4j
public class MessageServiceImpl implements MessageService {
    
    private final MessageRepository messageRepo;
    private final UserServiceImpl userService;


    @Override
    public Page<Message> getAllMessages(Principal user, Integer page, Integer targetId) {
        Users u = userService.getCurrentUser(user);
        Users tU = userService.findUserById(targetId);
        
        Pageable pageable = PageRequest.of(page, 5);
        Page<Message> pageOfMessages = messageRepo.pageOfMessages(u, tU, pageable);

        log.info("""
                \n
                
                Total number of elements: {}
                Total number of pages   : {}
                Total elements per page : {}
                Current page            : {}
                """,
                 pageOfMessages.getTotalElements(),
                 pageOfMessages.getTotalPages(),
                 5,
                 pageOfMessages.getNumber());

        return pageOfMessages;
    }

    @Override
    public Message saveMessage(Message message) {

        return messageRepo.save(message);
    }

    @Override
    public List<Message> getAllUnread(Principal user) {
        return null;
    }

    @Override
    public List<Message> getAllUnreadFromChat(Principal user, Integer targetId) {
        return null;
    }
}
