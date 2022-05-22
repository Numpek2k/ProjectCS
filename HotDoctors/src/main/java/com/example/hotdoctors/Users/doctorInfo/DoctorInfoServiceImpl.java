package com.example.hotdoctors.Users.doctorInfo;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.profession.ProfessionRepository;
import com.example.hotdoctors.Users.users.UserRepository;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorInfoServiceImpl implements DoctorInfoService {
    private final DoctorInfoRepository doctorInfoRepo;
    private final ProfessionRepository profRepo;
    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepo;

    @Override
    public DoctorInfo findDoctorById(Integer id) {

        return doctorInfoRepo.findById(id).orElseThrow();
    }
    @Override
    public List<DoctorInfo> findAllDoctors() {

        return doctorInfoRepo.findAll();
    }
    @Override
    public List<DoctorInfo> findAllDoctorsByAddress(String address) {

        return doctorInfoRepo.findAllByAddress(address);
    }
    @Override
    public List<DoctorInfo> findAllDoctorsByProfession(String profession) {

        return doctorInfoRepo.findAllByProfession(profession);
    }
    @Override
    public List<DoctorInfo> findAllDoctorsByAddressAndProfession(String address, String profession) {

        return doctorInfoRepo.findAllByAddressAndProfession(address, profession);
    }


    @Override
    public Profession saveProfession(Profession profession) {

        return profRepo.save(profession);
    }
    @Override
    public void deleteProfession(Integer profId) {

        profRepo.deleteById(profId);
    }
    @Override
    public Profession findProfById(Integer profId) {

        return profRepo.findById(profId).orElseThrow();
    }
    @Override
    public List<Profession> findAllProf() {

        return profRepo.findAll();
    }
    @Override
    public void addProfToUser(Integer userId, Integer profId) {
        Users user = userServiceImpl.findUserById(userId);
        Profession prof = findProfById(profId);
        user.getDoctorInfo().getProfessionList().add(prof);
        userRepo.save(user);
    }


}
