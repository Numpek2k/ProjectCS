package com.example.hotdoctors.Users.doctorInfo;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class DoctorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imagePath;
    private String description;
    private String address;

    public DoctorInfo(String address) {
        this.address = address;
    }



    @JsonIgnore
    @OneToOne(mappedBy = "doctorInfo")
    private Users user;

    @ManyToMany
    @JoinTable(
            name = "doctor_profession",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private List<Profession> professionList = new ArrayList<>();
}