package com.example.hotdoctors.Users.doctorInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorInfoRepository extends JpaRepository <DoctorInfo, Integer> {
}
