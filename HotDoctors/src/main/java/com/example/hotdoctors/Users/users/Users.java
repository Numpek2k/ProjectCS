package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Comment.Comment;
import com.example.hotdoctors.Message.Message;
import com.example.hotdoctors.Schedule.Schedule;
import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Visit.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;


    public Users(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }




    @ManyToOne
    @JoinColumn(name = "user_role")
    private Role role = new Role();

    @JsonIgnore
    @OneToOne( mappedBy = "users",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private DoctorInfo doctorInfo = new DoctorInfo();

    @JsonIgnore
    @OneToMany( mappedBy = "idWho",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Message> following = new ArrayList<>();

    @JsonIgnore
    @OneToMany( mappedBy = "idWhom",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Message> followers = new ArrayList<>();

    @JsonIgnore
    @OneToMany( mappedBy = "users",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Schedule> schedule = new ArrayList<>();

    @JsonIgnore
    @OneToMany( mappedBy = "idDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Visit> visitsDoctor = new ArrayList<>();

    @JsonIgnore
    @OneToMany( mappedBy = "idPatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Visit> visitsPatient = new ArrayList<>();

    @JsonIgnore
    @OneToMany( mappedBy = "idDoctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Comment> commentDoctor = new ArrayList<>();

    @OneToMany( mappedBy = "idPatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Comment> commentPatient = new ArrayList<>();
}