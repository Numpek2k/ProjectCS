package com.example.hotdoctors.Message;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.List;

public interface MessageService {

    Message saveMessage(Principal user, Integer targetID, Message message);

    Page<Message> getAllMessages(Principal user, Integer page, Integer targetId);
    List<Message> getAllUnread(Principal user);
    List<Message> getAllUnreadFromChat(Principal user, Integer targetId);
    List<Message> getUserToUserMessages(Principal user, Integer targetId);
    List<Users> getCorrespondents(Principal user);
}
