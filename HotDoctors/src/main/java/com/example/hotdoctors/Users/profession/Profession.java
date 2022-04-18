package com.example.hotdoctors.Users.profession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profession {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "genProfession"
    )
    @SequenceGenerator(
        name = "genProfession",
        allocationSize = 1
    )
    Integer id;

    @NotBlank
    String name;
}
