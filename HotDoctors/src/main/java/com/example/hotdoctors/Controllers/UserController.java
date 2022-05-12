package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @AllArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;


    @PostMapping("/save/user")
    public ResponseEntity<Users> saveUser(@RequestBody @Valid Users user) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/user").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveUser(user));
    }
    @PostMapping("/save/prof")
    public ResponseEntity<Profession> saveProfession(@RequestBody Profession profession) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/prof").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveProfession(profession));
    }
    @PostMapping("/save/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/role").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveRole(role));
    }


    @DeleteMapping("/delete/user")
    public void deleteUser(Integer id) { userServiceImpl.deleteUser(id); }
    @DeleteMapping ("/delete/prof")
    public void deleteProfession(Integer id) { userServiceImpl.deleteProfession(id); }
    @DeleteMapping("/delete/role")
    public void deleteRole(Integer id) { userServiceImpl.deleteRole(id); }


    @GetMapping("/find/user")
    public ResponseEntity<Users> findUser(Integer id) {
        return ResponseEntity.ok().body(userServiceImpl.findUserById(id));
    }
    @GetMapping("/find/prof")
    public ResponseEntity<Profession> findProf(Integer id) {
        return ResponseEntity.ok().body(userServiceImpl.findProfById(id));
    }
    @GetMapping("/find/role")
    public ResponseEntity<Role> findRole(Integer id) {
        return ResponseEntity.ok().body(userServiceImpl.findRoleById(id));
    }


    @GetMapping("/find/user/all")
    public ResponseEntity<List<Users>> findUserAll() {
        return ResponseEntity.ok().body(userServiceImpl.findAllUsers());
    }
    @GetMapping("/find/prof/all")
    public ResponseEntity<List<Profession>> findProfAll() {
        return ResponseEntity.ok().body(userServiceImpl.findAllProf());
    }
    @GetMapping("find/role/all")
    public ResponseEntity<List<Role>> findRoleAll() {
        return ResponseEntity.ok().body(userServiceImpl.findAllRole());

    }


    @PatchMapping("/add/prof")
    public ResponseEntity<?> addProfToUser(@RequestParam Integer userId, @RequestParam Integer profId) {
        userServiceImpl.addProfToUser(userId, profId);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/add/role")
    public ResponseEntity<?> addRoleToUser(@RequestParam Integer userId, @RequestParam Integer roleId) {
        userServiceImpl.addRoleToUser(userId, roleId);
        return ResponseEntity.ok().build();
    }
}
