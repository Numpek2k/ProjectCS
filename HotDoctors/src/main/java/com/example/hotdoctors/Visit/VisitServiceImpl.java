package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.UserServiceImpl;
import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final UserServiceImpl userService;


    @Override
    public Visit registerVisit(Visit visit) {
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
