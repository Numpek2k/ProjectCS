package com.example.hotdoctors.Visit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public void registerVisit(Visit visit) {

        visitRepository.save(visit);
    }

    @Override
    public void cancelVisit(Integer visitId) {

        visitRepository.deleteById(visitId);
    }

    @Override
    public List<Visit> getAllDoctorVisits(Integer doctorId) {

        return visitRepository.findAllById(doctorId);
    }

    @Override
    public Visit getVisit(Integer visitId) {

        return visitRepository.findById(visitId).orElseThrow();
    }
}
