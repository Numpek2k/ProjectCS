package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Users.doctorInfo.DoctorInfoRepository;
import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.profession.ProfessionRepository;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Users.role.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @AllArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProfessionRepository profRepository;
    private final BCryptPasswordEncoder BCryptPasswordEncoder;
    private final DoctorInfoRepository doctorInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User not found in the database");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }


    @Override
    public Users saveUser(Users user, Boolean isDoctor) {
        user.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));

        if (isDoctor) {
            user.setRole(roleRepository.findByName("DOCTOR"));
            DoctorInfo doctorInfo = new DoctorInfo();
            doctorInfoRepository.save(doctorInfo);
            user.setDoctorInfo(doctorInfo);
        }
        else user.setRole(roleRepository.findByName("PATIENT"));

        return userRepository.save(user);
    }
    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Profession saveProfession(Profession profession) { return profRepository.save(profession); }

    @Override
    public void updateUserName(Principal user, String name) {
        Users u = getCurrentUser(user);
        u.setName(name);
        userRepository.save(u);
    }
    @Override
    public void updateUserSurname(Principal user, String surname) {
        Users u = getCurrentUser(user);
        u.setSurname(surname);
        userRepository.save(u);
    }
    @Override
    public void updateUserEmail(Principal user, String email) {
        Users u = getCurrentUser(user);
        u.setEmail(email);
        userRepository.save(u);
    }
    @Override
    public void updateUserPassword(Principal user, String password) {
        Users u = getCurrentUser(user);
        u.setPassword(password);
        userRepository.save(u);
    }
    @Override
    public void updateUserDoctorInfo(Principal user, DoctorInfo doctorInfo) {
        Users u = getCurrentUser(user);
        u.setDoctorInfo(doctorInfo);
        userRepository.save(u);
    }



    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
    @Override
    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
    @Override
    public void deleteProfession(Integer profId) { profRepository.deleteById(profId); }



    @Override
    public Users findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }
    @Override
    public Users findUserByEmail(String email) { return userRepository.findUserByEmail(email); }
    @Override
    public Role findRoleById(Integer roleId) {
        return roleRepository.findById(roleId).orElseThrow();
    }
    @Override
    public Profession findProfById(Integer profId) { return profRepository.findById(profId).orElseThrow(); }



    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
    @Override
    public List<Profession> findAllProf() { return profRepository.findAll(); }



    @Override
    public void addRoleToUser(Integer userId, Integer roleId) {
        Users user = findUserById(userId);
        Role role =  findRoleById(roleId);
        user.setRole(role);
        userRepository.save(user);
    }
    @Override
    public void addProfToUser(Integer userId, Integer profId) {
        Users user = findUserById(userId);
        Profession prof = findProfById(profId);
        user.getDoctorInfo().getProfessionList().add(prof);
        userRepository.save(user);
    }

    @Override
    public Users getCurrentUser(Principal user) {
        String email = user.getName();
        return findUserByEmail(email);
    }

    public Profession findProfessionByName(String name){
        return profRepository.findProfByName(name);
    }
}