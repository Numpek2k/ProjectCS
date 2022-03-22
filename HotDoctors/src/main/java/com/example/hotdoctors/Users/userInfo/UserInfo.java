package com.example.hotdoctors.Users.userInfo;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {

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

    String profession;
    String imagePath;
    String description;
    String address;

    @OneToOne
    @JoinColumn(name = "idUser")
    Users users;
}
