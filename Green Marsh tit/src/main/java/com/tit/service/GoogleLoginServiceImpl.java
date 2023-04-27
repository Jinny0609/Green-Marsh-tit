package com.tit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tit.mapper.GoogleMapper;
import com.tit.model.GoogleVO;


public class GoogleLoginServiceImpl implements GoogleLoginService{
	@Autowired
	private GoogleMapper googleMapper;
	
	public void googleLogin(GoogleVO googleVO) {
		googleMapper.googlelogin(googleVO);
	}
}
