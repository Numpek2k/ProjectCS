package com.example.hotdoctors.Schedule;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository <Schedule, Integer> {

    @Query("SELECT o FROM Schedule o WHERE o.user = ?1 AND o.date >= ?2 AND o.date <= ?3")
    List<Schedule> getSchedule(Users user, Date From, Date to);

    List<Schedule> findAllByUser(Users user);

}
