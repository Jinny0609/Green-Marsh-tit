package com.tit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tit.mapper.UserProfileMapper;
import com.tit.model.UserProfile;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileMapper userProfileMapper;

    public void addUserProfile(UserProfile userProfile) {
        userProfileMapper.insertUserProfile(userProfile);
    }

    public int findUserProfileByEmail(String email) {
        return userProfileMapper.findByEmail(email);
    }

	public void delUserProfile(UserProfile userProfile1) {
		userProfileMapper.delUserProfile(userProfile1);
		// 회원탈퇴 -> DB 회원 삭제
	}
}