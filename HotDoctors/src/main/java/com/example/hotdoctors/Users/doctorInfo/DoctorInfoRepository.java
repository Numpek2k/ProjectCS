package com.example.hotdoctors.Users.doctorInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorInfoRepository extends JpaRepository <DoctorInfo, Integer> {

    List<DoctorInfo> findAllByAddress(String address);
    List<DoctorInfo> findAllByProfession(String profession);
    List<DoctorInfo> findAllByAddressAndProfession(String address, String profession);
}
