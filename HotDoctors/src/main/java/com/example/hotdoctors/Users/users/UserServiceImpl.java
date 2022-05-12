package com.example.hotdoctors.Users.users;

import com.example.hotdoctors.Users.doctorInfo.DoctorInfoRepository;
import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.profession.ProfessionRepository;
import com.example.hotdoctors.Users.role.Role;
import com.example.hotdoctors.Users.role.RoleRepository;
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

@Service @AllArgsConstructor @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final ProfessionRepository profRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUserByName(username);
        if (user == null) throw new UsernameNotFoundException("User not found in the database");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
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
    public Role saveRole(Role role) {
        return roleRepository.save(role);
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
    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }


    @Override
    public Users findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }
    @Override
    public Profession findProfById(Integer profId) { return profRepository.findById(profId).orElseThrow(); }
    @Override
    public Role findRoleById(Integer roleId) {
        return roleRepository.findById(roleId).orElseThrow();
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
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }


    @Override
    public void addProfToUser(Integer userId, Integer profId) {
        Users user = findUserById(userId);
        Profession prof = findProfById(profId);
        user.getDoctorInfo().getProfessionList().add(prof);
        userRepository.save(user);
    }
    @Override
    public void addRoleToUser(Integer userId, Integer roleId) {
        Users user = findUserById(userId);
        Role role =  findRoleById(roleId);
        user.setRole(role);
        userRepository.save(user);
    }
}
