package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Comment.Comment;
import com.example.hotdoctors.Comment.CommentServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @AllArgsConstructor @RequestMapping("/comment")
public class CommentController {

    private final CommentServiceImpl commentServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody @Valid Comment comment){
        return ResponseEntity.ok(commentServiceImpl.addComment(comment));
    }

    @GetMapping("/author")
    public ResponseEntity<Users> getAuthor(@RequestParam Integer id){
        return ResponseEntity.ok(commentServiceImpl.getAuthor(id));
    }

    @GetMapping
    public ResponseEntity<Comment> getComment(@RequestParam Integer id){
        return ResponseEntity.ok(commentServiceImpl.getComment(id));
    }

    @GetMapping("/addressee")
    public ResponseEntity<List<Comment>> getCommentByAddressee(@RequestParam Integer id){
        return ResponseEntity.ok(commentServiceImpl.getCommentsByAddressee(id));
    }

    @GetMapping("/newest")
    public ResponseEntity<List<Comment>> getNewestComments(){
        return ResponseEntity.ok(commentServiceImpl.getNewestComments());
    }
}
