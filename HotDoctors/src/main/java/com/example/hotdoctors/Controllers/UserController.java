package com.example.hotdoctors.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//@CrossOrigin(origins = "*")
@RestController @AllArgsConstructor @Slf4j
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


    @GetMapping("/find/user/id")
    public ResponseEntity<Users> findUser(Integer id) {
        return ResponseEntity.ok().body(userServiceImpl.findUserById(id));
    }
    @GetMapping("/find/user/email")
    public ResponseEntity<Users> findUser(String email) {
        return ResponseEntity.ok().body(userServiceImpl.findUserByEmail(email));
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
        log.info("asjdnflksajdnfo");
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

                String access_token = JWT.create()
                        .withSubject(user.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", Collections.singletonList(user.getRole().getName()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

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
}
