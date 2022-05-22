package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.role.Role;

import java.util.List;

public interface UserService {

    Users saveUser(Users user, Boolean isDoctor);
    Role saveRole(Role role);

    void deleteUser(Integer userId);
    void deleteRole(Integer roleId);

    Users findUserById(Integer userId);
    Users findUserByEmail(String email);

    Role findRoleById(Integer roleId);

    List<Users> findAllUsers();
    List<Role> findAllRoles();

    void addRoleToUser(Integer userId, Integer roleId);
}
