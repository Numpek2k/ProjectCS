package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    Status findByName(String name);
}
