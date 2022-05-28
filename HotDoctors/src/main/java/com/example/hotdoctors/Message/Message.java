package com.example.hotdoctors.Message;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    boolean read = false;

    @ManyToOne
    @JoinColumn(name = "id_who")
    private Users idWho;

    @ManyToOne
    @JoinColumn(name = "id_whom")
    private Users idWhom;
}
