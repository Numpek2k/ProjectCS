package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private Integer h_start;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;

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
