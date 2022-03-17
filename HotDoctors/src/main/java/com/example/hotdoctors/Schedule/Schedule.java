package com.example.hotdoctors.Schedule;


import com.example.hotdoctors.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
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
    private int id;
    private String day;
    private int h_start;
    private int h_end;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(String day, int h_start, int h_end, User user) {
        this.day = day;
        this.h_start = h_start;
        this.h_end = h_end;
        this.user = user;
    }
}
