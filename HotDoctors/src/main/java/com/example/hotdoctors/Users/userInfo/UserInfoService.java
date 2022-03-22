package com.example.hotdoctors.Users.userInfo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
}
