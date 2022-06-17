package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.Users;

import java.security.Principal;
import java.util.Date;
import java.util.List;

public interface VisitService {

    Visit registerVisit(Visit visit);
    void cancelVisit(Integer visitId);
    List<Visit> getAllVisits(Integer id, Date start, Date end);
    List<Visit> getAllPending(Principal user);
    Visit getVisit(Integer visitId);
    void updateVisit(Integer visitId, Visit visit);
}
