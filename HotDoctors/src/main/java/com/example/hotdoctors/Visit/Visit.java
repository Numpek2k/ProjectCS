package com.example.hotdoctors.Visit;

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
public class Visit {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genVisit"
    )
    @SequenceGenerator(
            name = "genVisit",
            allocationSize = 1
    )
    Integer id;
    Integer h_start;
    Date date;

    @ManyToOne
    @JoinColumn(name = "idDoctor")
    Users idDoctor;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    Users idPatient;

}
