package com.example.hotdoctors.Comment;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository
         extends JpaRepository <Comment, Integer> {

    List<Comment> findAllByIdDoctorOrderByDateDesc(Users users);
    List<Comment> findFirst5ByOrderByDateDesc();
}
