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
    private int doctor_id;
    private int patient_id;
    private String date;

    public Comment(String content, double rating, int doctor_id, int patient_id, String date) {
        this.content = content;
        this.rating = rating;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.date = date;
    }

    public void setId(int id) { this.id = id; }

    public void setContent(String content) { this.content = content; }

    public void setRating(double rating) { this.rating = rating; }

    public void setDoctor_id(int doctor_id) { this.doctor_id = doctor_id; }

    public void setPatient_id(int patient_id) { this.patient_id = patient_id; }

    public void setDate(String date) { this.date = date; }
}
