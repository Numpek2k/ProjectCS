package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.role.Role;

import java.security.Principal;
import java.util.List;

public interface UserService {

    Users saveUser(Users user, Boolean isDoctor);
    Role saveRole(Role role);
    Profession saveProfession(Profession profession);

    void updateUserName(Principal user, String name);
    void updateUserSurname(Principal user, String surname);
    void updateUserEmail(Principal user, String email);
    void updateUserPassword(Principal user, String password);
    void updateUserDoctorInfo(Principal user, DoctorInfo doctorInfo);

    void deleteUser(Integer userId);
    void deleteRole(Integer roleId);
    void deleteProfession(Integer profId);

    Users findUserById(Integer userId);
    Users findUserByEmail(String email);
    Role findRoleById(Integer roleId);
    Profession findProfById(Integer profId);

    List<Users> findAllUsers();
    List<Role> findAllRoles();
    List<Profession> findAllProf();

    void addRoleToUser(Integer userId, Integer roleId);
    void addProfToUser(Integer userId, Integer profId);

    Users getCurrentUser(Principal user);
}
