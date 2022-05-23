package com.example.hotdoctors.Visit;

import java.util.List;

public interface VisitService {

    void registerVisit(Visit visit);
    void cancelVisit(Integer visitId);
    List<Visit> getAllDoctorVisits(Integer doctorId);
    Visit getVisit(Integer visitId);
}
