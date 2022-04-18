package com.example.hotdoctors.Users.doctorInfo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorInfoService {
    private final DoctorInfoRepository doctorInfoRepository;
}
