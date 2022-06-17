package com.example.hotdoctors.Visit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Entity @Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Visit> visitList = new ArrayList<>();
}
