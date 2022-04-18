package com.example.hotdoctors.Users.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUserByName(String name);
}