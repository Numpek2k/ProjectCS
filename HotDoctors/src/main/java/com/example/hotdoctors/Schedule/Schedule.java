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
    private int start_h;
    private int end_h;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(String day, int start_h, int end_h, User user) {
        this.day = day;
        this.start_h = start_h;
        this.end_h = end_h;
        this.user = user;
    }

    public void setId(int id) { this.id = id; }

    public void setDay(String day) { this.day = day; }

    public void setStart_h(int start_h) { this.start_h = start_h; }

    public void setEnd_h(int end_h) { this.end_h = end_h; }

    public void setUser(User user) { this.user = user; }
}
