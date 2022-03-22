package com.example.hotdoctors.Comment;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genComment"
    )
    @SequenceGenerator(
            name = "genComment",
            allocationSize = 1
    )
    Integer id;

    String content;
    Integer rating;
    Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "idDoctor")
    Users idDoctor;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    Users idPatient;

}
