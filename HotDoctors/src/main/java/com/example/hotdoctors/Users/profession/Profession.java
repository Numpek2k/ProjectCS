package com.example.hotdoctors.Users.profession;

import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String name;

    public Profession(String name) { this.name = name; }


    @ManyToMany(mappedBy = "professionList")
    private List<DoctorInfo> usersList = new ArrayList<>();
}
