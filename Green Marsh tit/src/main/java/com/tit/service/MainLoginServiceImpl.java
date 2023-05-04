package com.tit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tit.mapper.MainLoginMapper;
import com.tit.model.MainLoginVO;

@Service
public class MainLoginServiceImpl implements MainLoginService{
	
	@Autowired
	MainLoginMapper mlm;
	
	public void memberjoin(MainLoginVO mainloginVO) {
	mlm.memberjoin(mainloginVO);
	System.out.println(mainloginVO);
	}
	
	public ArrayList<MainLoginVO> memberlogin(MainLoginVO mainloginVO) {
		return mlm.memberlogin(mainloginVO);
	}
	
	public void memberlogout(String email) {
		mlm.memberlogout(email);
	}

	public String checkPasswordByEmailAndSns(MainLoginVO mainLoginVO) {
		return mlm.checkPasswordByEmailAndSns(mainLoginVO);
	}
}
