package com.example.hotdoctors.Visit;

import com.example.hotdoctors.Users.users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;


    @Override
    public void registerVisit(Visit visit) {

    }

    @Override
    public void cancelVisit(Integer visitId) {

    }

    @Override
    public List<Visit> getAllVisits(Integer id, Date start, Date end) {
        return null;
    }

    @Override
    public Visit getVisit(Integer visitId) {
        return null;
    }

    @Override
    public void updateVisit() {

    }
}
