package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @AllArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/user/save")
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveUser(user));
    }

    @PostMapping("/prof/save")
    public ResponseEntity<Profession> saveProfession(@RequestBody Profession profession) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/prof/save").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveProfession(profession));
    }

    @PostMapping("/prof/add")
    public ResponseEntity<?> addProfToUser(@RequestParam Integer userId, @RequestParam String profName) {
        userServiceImpl.addProfToUser(userId, profName);
        return ResponseEntity.ok().build();
    }




    @DeleteMapping("/user/delete")
    public void deleteUser(Integer id) { userServiceImpl.deleteUser(id); }

    @DeleteMapping ("/prof/delete")
    public void deleteProfession(Integer id) { userServiceImpl.deleteProfession(id); }





    @GetMapping("/user/find")
    public ResponseEntity<Users> findUser(Integer id) {
        return ResponseEntity.ok().body(userServiceImpl.findUserById(id));
    }

    @GetMapping("/user/find/all")
    public ResponseEntity<List<Users>> findUserAll() {
        return ResponseEntity.ok().body(userServiceImpl.findAllUsers());
    }

    @GetMapping("/prof/find/all")
    public ResponseEntity<List<Profession>> findProfAll() {
        return ResponseEntity.ok().body(userServiceImpl.findAllProf());
    }

}
