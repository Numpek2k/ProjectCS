package com.example.hotdoctors.Users.doctorInfo;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genUserInfo"
    )
    @SequenceGenerator(
            name = "genUserInfo",
            allocationSize = 1
    )
    Integer id;

    @ManyToMany
    List<Profession> profession;

    String imagePath;

    String description;

    @NotBlank
    String address;

    @OneToOne
    @JoinColumn(name = "idUser")
    Users users;
}