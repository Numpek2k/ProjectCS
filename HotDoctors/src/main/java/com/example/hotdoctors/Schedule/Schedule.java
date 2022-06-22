package com.example.hotdoctors.Schedule;


import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private DayOfWeek day;

    private Integer h_start;

    private Integer h_end;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;
}
