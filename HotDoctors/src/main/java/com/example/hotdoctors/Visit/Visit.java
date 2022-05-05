package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private Integer h_start;

    @NotBlank
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idStatus")
    private Status status;


    @ManyToOne
    @JoinColumn(name = "idDoctor")
    private Users idDoctor;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    private Users idPatient;
}
