package com.tit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tit.mapper.GoogleMapper;
import com.tit.model.GoogleProfile;

@Service
public class GoogleProfileService {
    @Autowired
    private GoogleMapper googleMapper;

    public void addUserProfile(GoogleProfile googleProfile) {
    	googleMapper.insertUserProfile(googleProfile);
    }

    public int findUserProfileByEmail(String email) {
        return googleMapper.findByEmail(email);
    }

	public void delUserProfile(GoogleProfile delProfile) {
		googleMapper.delUserProfile(delProfile);
		// 회원탈퇴 -> DB 회원 삭제
	}
}