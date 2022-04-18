package com.example.hotdoctors.Users.profession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
    Profession findProfByName(String name);
}
