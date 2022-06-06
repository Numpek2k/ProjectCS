package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Visit.Visit;
import com.example.hotdoctors.Visit.VisitServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController @AllArgsConstructor @RequestMapping("/visit")
public class VisitController {

    private final VisitServiceImpl visitServiceImpl;

    @GetMapping("/get")
    public ResponseEntity<Visit> getVisitById(Integer id) {
        return ResponseEntity.ok().body(visitServiceImpl.getVisit(id));
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<Visit>> getAllVisitsFromPeriod(Integer id, Date start, Date end) {
        return ResponseEntity.ok().body(visitServiceImpl.getAllVisits(id, start, end));
    }

    @PostMapping("/save")
    public ResponseEntity<Visit> registerVisit(Visit visit) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save/prof").toUriString());
        return ResponseEntity.created(uri).body(visitServiceImpl.registerVisit(visit));
    }

    @DeleteMapping("/delete")
    public void deleteVisit(Integer id) { visitServiceImpl.cancelVisit(id); }

    @PatchMapping("/update")
    public ResponseEntity<?> updateVisit(Integer visitId, Visit visit) {
        visitServiceImpl.updateVisit(visitId, visit);
        return ResponseEntity.ok().build();
    }



}
