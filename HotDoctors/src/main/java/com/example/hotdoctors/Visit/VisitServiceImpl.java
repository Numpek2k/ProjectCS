package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Schedule.ScheduleRepository;
import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final StatusRepository statusRepository;
    private final VisitRepository visitRepository;
    private final UserServiceImpl userService;


    @Override
    public Visit registerVisit(Visit visit) {
        Status status = statusRepository.findByName("PENDING");
        visit.setStatus(status);
        return visitRepository.save(visit);
    }


    @Override
    public void cancelVisit(Integer visitId) {
        visitRepository.deleteById(visitId);
    }


    @Override
    public List<Visit> getAllVisits(Integer userId, Date start, Date end) {
        Users u = userService.findUserById(userId);
        return visitRepository.findAllByDates(u, start, end);
    }
    @Override
    public List<Visit> getAllPending(Principal user) {
        Status status = statusRepository.findByName("PENDING");
        Users us = userService.getCurrentUser(user);
        return visitRepository.findAllPending(us, status);
    }
    @Override
    public Visit getVisit(Integer visitId) {
        return visitRepository.findById(visitId).orElseThrow();
    }


    @Override
    public void updateVisit(Integer visitId, Visit visit) {
        Visit original = getVisit(visitId);
        if (visit.getH_start() != null) original.setH_start(visit.getH_start());
        if (visit.getDate() != null) original.setDate(visit.getDate());
        if (visit.getDescription() != null) original.setDescription(visit.getDescription());
        if (visit.getStatus() != null) original.setStatus(visit.getStatus());
        visitRepository.save(original);
    }
}
