package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.profession.ProfessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final ProfessionRepository profRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUserByName(username);
        if (user == null) throw new UsernameNotFoundException("User not found in the database");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }



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
    public List<Profession> findAllProf() {
        return profRepository.findAll();
    }

    @Override
    public void addProfToUser(Integer userId, String profName) {
        Users user = findUserById(userId);
        Profession prof = profRepository.findProfByName(profName);
        user.getDoctorInfo().getProfession().add(prof);
    }
}
