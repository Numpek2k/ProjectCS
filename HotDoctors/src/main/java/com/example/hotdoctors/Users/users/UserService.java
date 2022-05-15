package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.role.Role;

import java.util.List;

public interface UserService {

    Users saveUser(Users user);
    Profession saveProfession(Profession profession);
    Role saveRole(Role role);

    void deleteUser(Integer userId);
    void deleteProfession(Integer profId);
    void deleteRole(Integer roleId);

    Users findUserById(Integer userId);
    Users findUserByEmail(String email);

    Profession findProfById(Integer profId);
    Role findRoleById(Integer roleId);

    List<Users> findAllUsers();
    List<Profession> findAllProf();
    List<Role> findAllRole();

    void addProfToUser(Integer userId, Integer profId);
    void addRoleToUser(Integer userId, Integer roleId);
}
