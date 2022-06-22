package com.example.hotdoctors.Users.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUserByEmail(String email);

    @Query(value = "SELECT o FROM Users o WHERE o.name LIKE %?1% OR o.surname LIKE %?1% OR o.doctorInfo.address LIKE %?1%")
    List<Users> findDoctor(String thing);
}