package com.example.hotdoctors.Visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
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
    private int id;
    private int id_doctor;
    private int id_patient;
    private int h_start;
    private String date;


    public Visit(int id_doctor, int id_patient, int h_start, String date) {
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.h_start = h_start;
        this.date = date;
    }
}
