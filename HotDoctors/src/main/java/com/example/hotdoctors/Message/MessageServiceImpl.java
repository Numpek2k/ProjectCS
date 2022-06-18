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
    public Message saveMessage(Principal user, Integer targetId, Message message) {
        Users u = userService.getCurrentUser(user);
        Users tU = userService.findUserById(targetId);

        message.setIdWho(u);
        message.setIdWhom(tU);

        return messageRepo.save(message);
    }

    @Override
    public List<Message> getAllUnread(Principal user) {
        Users u = userService.getCurrentUser(user);
        return messageRepo.allUnread(u);
    }

    @Override
    public List<Message> getAllUnreadFromChat(Principal user, Integer targetId) {
        Users u = userService.getCurrentUser(user);
        Users tU = userService.findUserById(targetId);
        return messageRepo.allUnreadFromChat(u, tU);
    }

    @Override
    public List<Message> getUserToUserMessages(Principal user, Integer targetId){
        Users u = userService.getCurrentUser(user);
        Users tU = userService.findUserById(targetId);
        return messageRepo.allUserToUserMessages(u, tU);
    }

    @Override
    public List<Users> getCorrespondents(Principal user){
        Users u = userService.getCurrentUser(user);
        return messageRepo.allCorrespondents(u);
    }


}
