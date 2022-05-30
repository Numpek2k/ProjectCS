package com.example.hotdoctors.Comment;

import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;


    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Users getAuthor(Integer id){
        Comment comment = commentRepository.getById(id);
        return comment.getIdPatient();
    }

    public Comment getComment(Integer id){
        return commentRepository.getById(id);
    }

    public List<Comment> getCommentsByAddressee(Integer id){
        return commentRepository.findAllByIdDoctor(userService.findUserById(id));
    }

    public List<Comment> getNewestComments(){
        return commentRepository.findFirst5ByOrderByDateDesc();
    }
}
