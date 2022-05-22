package com.example.hotdoctors.Users.doctorInfo;

import com.example.hotdoctors.Users.profession.Profession;

import java.util.List;

public interface DoctorInfoService {

    DoctorInfo findDoctorById(Integer id);
    List<DoctorInfo> findAllDoctors();
    List<DoctorInfo> findAllDoctorsByAddress(String address);
    List<DoctorInfo> findAllDoctorsByProfession(String profession);
    List<DoctorInfo> findAllDoctorsByAddressAndProfession(String address, String profession);

    Profession saveProfession(Profession profession);
    void deleteProfession(Integer profId);
    Profession findProfById(Integer profId);
    List<Profession> findAllProf();
    void addProfToUser(Integer userId, Integer profId);

}
