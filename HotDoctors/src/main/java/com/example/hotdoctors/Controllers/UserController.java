package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Users.users.UserService;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/register")
    public void registerUser(Users user) { userService.registerUser(user); }

    @GetMapping("/delete")
    public void deleteUser(Integer id) { userService.deleteUser(id); }

    @GetMapping("/findUser")
    public Users findUser(Integer id) { return userService.findUserById(id); }

    @GetMapping("/findUserAll")
    public List<Users> findUserAll() { return userService.findAllUsers(); }

}
