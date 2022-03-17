package com.example.hotdoctors.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genUser"
    )
    @SequenceGenerator(
            name = "genUser",
            allocationSize = 1
    )
    private int id;

    private String name;
    private String surname;
    private String email;
    private String password;

    private UserType role;
    private String image;
    private String description;
    private String address;

    public User(String name, String surname, String email, String password, UserType role, String image, String description, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.image = image;
        this.description = description;
        this.address = address;
    }
}