package com.example.hotdoctors.Users.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void registerUser(Users user) {

        userRepository.save(user);
    }

    public void deleteUser(Integer id) {

        userRepository.deleteById(id);
    }

    public Users findUserById(Integer id) {

        return userRepository.findById(id).orElseThrow();
    }

    public List<Users> findAllUsers() {

        return userRepository.findAll();
    }
}
