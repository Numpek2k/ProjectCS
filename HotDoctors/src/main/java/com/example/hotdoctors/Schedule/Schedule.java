package com.example.hotdoctors.Schedule;


import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genSchedule"
    )
    @SequenceGenerator(
            name = "genSchedule",
            allocationSize = 1
    )
    Integer id;

    @NotBlank
    DayOfWeek day;
    Integer h_start;
    Integer h_end;

    @ManyToOne
    @JoinColumn(name = "idUser")
    Users users;

}
