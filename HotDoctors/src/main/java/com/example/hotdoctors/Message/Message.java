package com.example.hotdoctors.Message;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genMessage"
    )
    @SequenceGenerator(
            name = "genMessage",
            allocationSize = 1
    )
    Integer id;

    @NotBlank
    String content;

    @Temporal(TemporalType.TIMESTAMP)
    Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "id_who")
    Users idWho;

    @ManyToOne
    @JoinColumn(name = "id_whom")
    Users idWhom;
}
