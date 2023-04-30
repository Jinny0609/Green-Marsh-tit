package com.tit.service;

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

}
