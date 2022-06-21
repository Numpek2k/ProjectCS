package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository <Visit, Integer> {

    @Query(value = "SELECT o FROM Visit o WHERE o.idDoctor = ?1 ORDER BY o.date")
    List<Visit> findAll(Users user);

    @Query(value = "SELECT o FROM Visit o WHERE o.idDoctor = ?1 AND o.status = ?2")
    List<Visit> findAllPending(Users user, Status status);
}
