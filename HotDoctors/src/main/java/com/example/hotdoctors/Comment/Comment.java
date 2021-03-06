package com.example.hotdoctors.Comment;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String content;

    @Range(max = 5)
    private Integer rating;

    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "idDoctor")
    private Users idDoctor;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    private Users idPatient;
}
