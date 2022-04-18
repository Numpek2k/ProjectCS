package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;


    @PostMapping("/save_user")
    public void saveUser(Users user) { userServiceImpl.saveUser(user); }

    @PostMapping("/save_prof")
    public void saveProfession(Profession profession) { userServiceImpl.saveProfession(profession); }





    @DeleteMapping("/delete_user")
    public void deleteUser(Integer id) { userServiceImpl.deleteUser(id); }

    @DeleteMapping ("/delete_prof")
    public void deleteProfession(Integer id) { userServiceImpl.deleteProfession(id); }





    @GetMapping("/findUser")
    public Users findUser(Integer id) { return userServiceImpl.findUserById(id); }

    @GetMapping("/findUserAll")
    public List<Users> findUserAll() { return userServiceImpl.findAllUsers(); }

}
