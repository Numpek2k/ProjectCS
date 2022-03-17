package com.example.hotdoctors.Visit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
}
