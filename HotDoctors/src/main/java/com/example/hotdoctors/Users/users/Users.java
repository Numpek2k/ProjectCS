package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Comment.Comment;
import com.example.hotdoctors.Message.Message;
import com.example.hotdoctors.Schedule.Schedule;
import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Visit.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public Users(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Users(String name, String surname, String email, String password, DoctorInfo doctorInfo) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.doctorInfo = doctorInfo;
    }


    @ManyToOne
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorInfo doctorInfo;

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

    @JsonIgnore
    @OneToMany( mappedBy = "idPatient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Comment> commentPatient = new ArrayList<>();
}