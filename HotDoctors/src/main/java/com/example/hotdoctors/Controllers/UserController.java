package com.example.hotdoctors.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController @AllArgsConstructor @Slf4j
public class UserController {

    private final UserServiceImpl userServiceImpl;


    @PostMapping("/save/prof")
    public ResponseEntity<Profession> saveProfession(@RequestBody Profession profession) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/prof").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveProfession(profession));
    }
    @PostMapping("/save/user")
    public ResponseEntity<Users> saveUser(@RequestBody Users user, @RequestParam Boolean isDoctor) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/user").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveUser(user, isDoctor));
    }
    @PostMapping("/save/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/role").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveRole(role));
    }

    @PostMapping("/user/update/name")
    public ResponseEntity<?> updateUserName(Principal user, @RequestBody String name) {
        userServiceImpl.updateUserName(user, name);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/user/update/surname")
    public ResponseEntity<?> updateUserSurname(Principal user, @RequestBody String surname) {
        userServiceImpl.updateUserSurname(user, surname);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/user/update/email")
    public ResponseEntity<?> updateUserEmail(Principal user, @RequestBody String email) {
        userServiceImpl.updateUserEmail(user, email);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/user/update/password")
    public ResponseEntity<?> updateUserPassword(Principal user, @RequestBody String password) {
        userServiceImpl.updateUserPassword(user, password);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/user/update/doctorInfo")
    public ResponseEntity<?> updateUserDoctorInfo(Principal user,
                                                  @RequestBody DoctorInfo doctorInfo) {
        userServiceImpl.updateUserDoctorInfo(user, doctorInfo);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete/user")
    public void deleteUser(Integer id) { userServiceImpl.deleteUser(id); }
    @DeleteMapping("/delete/role")
    public void deleteRole(Integer id) { userServiceImpl.deleteRole(id); }
    @DeleteMapping("/delete/prof")
    public void deleteProfession(Integer id) { userServiceImpl.deleteProfession(id); }




    @GetMapping("/find/prof")
    public ResponseEntity<Profession> findProf(Integer id) {
        Profession prof = userServiceImpl.findProfById(id);
        if (prof == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(prof);
    }
    @GetMapping("/find/user/id")
    public ResponseEntity<Users> findUser(Integer id) {
        Users user = userServiceImpl.findUserById(id);
        if (user == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(user);
    }
    @GetMapping("/find/user/email")
    public ResponseEntity<Users> findUser(String email) {
        Users user = userServiceImpl.findUserByEmail(email);
        if (user == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(user);
    }
    @GetMapping("/find/role")
    public ResponseEntity<Role> findRole(Integer id) {
        Role role = userServiceImpl.findRoleById(id);
        if (role == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(role);
    }
    @GetMapping("/find/doc")
    public ResponseEntity<List<Users>> findDocAllBy(String thing) {
        List<Users> docList = userServiceImpl.getDoctors(thing);
        if (docList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(docList);
    }


    @GetMapping("/find/user/all")
    public ResponseEntity<List<Users>> findUserAll() {
        List<Users> userList = userServiceImpl.findAllUsers();
        if (userList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(userList);
    }
    @GetMapping("find/role/all")
    public ResponseEntity<List<Role>> findRoleAll() {
        List<Role> roleList = userServiceImpl.findAllRoles();
        if (roleList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(roleList);
    }
    @GetMapping("/find/prof/all")
    public ResponseEntity<List<Profession>> findProfAll() {
        List<Profession> profList = userServiceImpl.findAllProf();
        if (profList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(profList);
    }



    @PatchMapping("/add/role")
    public ResponseEntity<?> addRoleToUser(@RequestParam Integer userId, @RequestParam Integer roleId) {
        userServiceImpl.addRoleToUser(userId, roleId);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/add/prof")
    public ResponseEntity<?> addProfToUser(@RequestParam Integer userId, @RequestParam Integer profId) {
        userServiceImpl.addProfToUser(userId, profId);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);

                String email = decodedJWT.getSubject();
                Users user = userServiceImpl.findUserByEmail(email);

                String access_token =
                        "Bearer " +
                        JWT.create()
                        .withSubject(user.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", Collections.singletonList(user.getRole().getName()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", "Bearer " + refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            } catch (Exception exception) {
                log.error("Error logging in: {}", exception.getMessage());
                response.setHeader("error ", exception.getMessage());
                response.setStatus(FORBIDDEN.value());

                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else throw new RuntimeException("Refresh token is missing");
    }

    @GetMapping("/find/user/current")
    public ResponseEntity<Users> findCurrentUser(Principal user) {
        log.info("USER: {}", user);
        return ResponseEntity.ok().body(userServiceImpl.getCurrentUser(user));
    }

    @GetMapping("/find/user/prof")
    public ResponseEntity<List<Users>> findUsersByProf(@RequestParam String prof){
        List<DoctorInfo> doctorInfos = userServiceImpl.findProfessionByName(prof).getUsersList();
        List<Users> usersList = doctorInfos.stream().map(DoctorInfo::getUser).collect(Collectors.toList());
        return ResponseEntity.ok(usersList);
    }

}
