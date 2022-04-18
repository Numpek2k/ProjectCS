package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.profession.Profession;

import java.util.List;

public interface UserService {

    void saveUser(Users user);
    void saveProfession(Profession profession);

    void deleteUser(Integer userId);
    void deleteProfession(Integer profId);

    Users findUserById(Integer userId);
    List<Users> findAllUsers();
    void addProfToUser(Integer userId, String profName);
}
