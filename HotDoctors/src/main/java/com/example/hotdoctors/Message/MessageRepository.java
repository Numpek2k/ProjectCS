package com.example.hotdoctors.Message;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository <Message, Integer> {

    @Query(value = "SELECT o FROM Message o WHERE o.idWho = ?1 AND o.idWhom = ?2 ORDER BY o.date")
    Page<Message> pageOfMessages(Users user, Users targetUser, Pageable pageable);
}
