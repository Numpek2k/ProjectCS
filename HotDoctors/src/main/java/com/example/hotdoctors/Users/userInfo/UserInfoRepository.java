package com.example.hotdoctors.Users.userInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository <UserInfo, Integer> {
}
