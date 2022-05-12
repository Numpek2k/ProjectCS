package com.example.hotdoctors.Users.role;

import com.example.hotdoctors.Users.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @JsonIgnore
    @OneToMany( mappedBy = "role",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Users> users;
}
