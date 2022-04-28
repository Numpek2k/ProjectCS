package com.example.hotdoctors.Users.users.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleInterface extends JpaRepository<Role, Integer> {
}
