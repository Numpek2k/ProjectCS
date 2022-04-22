package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.profession.ProfessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProfessionRepository profRepository;

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Profession saveProfession(Profession profession) {
        return profRepository.save(profession);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void deleteProfession(Integer profId) {
        profRepository.deleteById(profId);
    }

    @Override
    public Users findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addProfToUser(Integer userId, String profName) {
        Users user = findUserById(userId);
        Profession prof = profRepository.findProfByName(profName);
        user.getDoctorInfo().getProfession().add(prof);
    }
}
