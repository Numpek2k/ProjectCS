package com.example.hotdoctors.Schedule;


import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private DayOfWeek day;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Integer h_start;

    private Integer h_end;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;
}
