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

    public void setId(int id) { this.id = id; }

    public void setDay(String day) { this.day = day; }

    public void setStart_h(int h_start) { this.h_start = h_start; }

    public void setEnd_h(int h_end) { this.h_end = h_end; }

    public void setUser(User user) { this.user = user; }
}
