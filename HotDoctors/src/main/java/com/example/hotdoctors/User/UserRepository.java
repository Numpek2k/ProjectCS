package com.example.hotdoctors.User;

import com.example.hotdoctors.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
         extends JpaRepository<User, Integer> {
}