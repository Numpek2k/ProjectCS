package com.example.hotdoctors.Message;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository <Message, Integer> {



    @Query(value = "SELECT o FROM Message o WHERE o.idWho = ?1 AND o.idWhom = ?2 ORDER BY o.date")
    Page<Message> pageOfMessages(Users user, Users targetUser, Pageable pageable);

    @Query(value = "SELECT o FROM Message o WHERE o.idWho = ?1 ORDER BY o.date")
    List<Message> allUnread(Users user);

    @Query(value = "SELECT o FROM Message o WHERE o.idWho = ?1 AND o.idWho = ?2 AND o.read = false ORDER BY o.date")
    List<Message> allUnreadFromChat(Users user, Users targetUser);
}
