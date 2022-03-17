package com.example.hotdoctors.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
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
    private int id;
    private String content;
    private double rating;
    private int id_doctor;
    private int id_patient;
    private String date;

    public Comment(String content, double rating, int id_doctor, int id_patient, String date) {
        this.content = content;
        this.rating = rating;
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.date = date;
    }
}
