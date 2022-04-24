package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Comment.Comment;
import com.example.hotdoctors.Message.Message;
import com.example.hotdoctors.Schedule.Schedule;
import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Visit.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    public Users (String name, String surname, String email, String password, UserType role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        following = new ArrayList<>();
        followers = new ArrayList<>();
        schedule = new ArrayList<>();
        visitsDoctor = new ArrayList<>();
        visitsPatient = new ArrayList<>();
        commentDoctor = new ArrayList<>();
        commentPatient = new ArrayList<>();
    }


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genUser"
    )
    @SequenceGenerator(
            name = "genUser",
            allocationSize = 1
    )
    Integer id;

    @NotBlank
    String name;

    @NotBlank
    String surname;

    @NotBlank
    @Email
    @Column(unique = true)
    String email;

    @NotBlank
    String password;

    Enum<UserType> role;

    @JsonIgnore
    @OneToOne( mappedBy = "users",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    DoctorInfo doctorInfo;

    @JsonIgnore
    @OneToMany( mappedBy = "idWho",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Message> following;

    @JsonIgnore
    @OneToMany( mappedBy = "idWhom",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Message> followers;

    @JsonIgnore
    @OneToMany( mappedBy = "users",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Schedule> schedule;

    @JsonIgnore
    @OneToMany( mappedBy = "idDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Visit> visitsDoctor;

    @JsonIgnore
    @OneToMany( mappedBy = "idPatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Visit> visitsPatient;

    @JsonIgnore
    @OneToMany( mappedBy = "idDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Comment> commentDoctor;

    @OneToMany( mappedBy = "idPatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Comment> commentPatient;
}