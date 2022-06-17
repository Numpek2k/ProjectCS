package com.example.hotdoctors.Schedule;

import com.example.hotdoctors.Users.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository <Schedule, Integer> {

    @Query(value = "SELECT o FROM Schedule o WHERE o.user = ?1")
    List<Schedule> getSchedule(Users user);

    @Query(value = "SELECT o FROM Schedule o WHERE o.user = ?1 AND o.day = ?2")
    Schedule findByDay(Users user, Integer id);
}
