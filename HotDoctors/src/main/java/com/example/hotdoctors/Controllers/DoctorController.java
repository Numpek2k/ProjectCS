package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Users.doctorInfo.DoctorInfo;
import com.example.hotdoctors.Users.doctorInfo.DoctorInfoServiceImpl;
import com.example.hotdoctors.Users.profession.Profession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @AllArgsConstructor @Slf4j
public class DoctorController {

    private final DoctorInfoServiceImpl doctorServiceImpl;

    @PostMapping("/save/prof")
    public ResponseEntity<Profession> saveProfession(@RequestBody Profession profession) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/prof").toUriString());
        return ResponseEntity.created(uri).body(doctorServiceImpl.saveProfession(profession));
    }



    @GetMapping("/find/prof")
    public ResponseEntity<Profession> findProf(Integer id) {
        return ResponseEntity.ok().body(doctorServiceImpl.findProfById(id));
    }
    @GetMapping("/find/doctor")
    public ResponseEntity<DoctorInfo> findDoctor(Integer id) {
        return ResponseEntity.ok().body(doctorServiceImpl.findDoctorById(id));
    }



    @DeleteMapping("/delete/prof")
    public void deleteProfession(Integer id) {

        doctorServiceImpl.deleteProfession(id);
    }



    @GetMapping("/find/prof/all")
    public ResponseEntity<List<Profession>> findProfAll() {
        return ResponseEntity.ok().body(doctorServiceImpl.findAllProf());
    }
    @GetMapping("/find/doctor/all")
    public ResponseEntity<List<DoctorInfo>> findDoctorAll() {
        return ResponseEntity.ok().body(doctorServiceImpl.findAllDoctors());
    }
    @GetMapping("/find/doctor/all/address")
    public ResponseEntity<List<DoctorInfo>> findDoctorAllAddress(String address) {
        return ResponseEntity.ok().body(doctorServiceImpl.findAllDoctorsByAddress(address));
    }
    @GetMapping("/find/doctor/all/profession")
    public ResponseEntity<List<DoctorInfo>> findDoctorAllProfession(String profession) {
        return ResponseEntity.ok().body(doctorServiceImpl.findAllDoctorsByProfession(profession));
    }
    @GetMapping("/find/doctor/all/addressAndProfession")
    public ResponseEntity<List<DoctorInfo>> findDoctorAllAddressProfession(String address, String profession) {
        return ResponseEntity.ok().body(doctorServiceImpl.findAllDoctorsByAddressAndProfession(address, profession));
    }

    @PatchMapping("/add/prof")
    public ResponseEntity<?> addProfToUser(@RequestParam Integer userId, @RequestParam Integer profId) {
        doctorServiceImpl.addProfToUser(userId, profId);
        return ResponseEntity.ok().build();
    }



}
