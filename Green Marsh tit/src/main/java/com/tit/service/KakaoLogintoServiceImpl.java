package com.tit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tit.mapper.KakaoMapper;
import com.tit.model.LoginVO;

@Service
public class KakaoLogintoServiceImpl implements KakaoLogintoService {
	
	@Autowired
	KakaoMapper kmp;
	
	public void kakaologin(LoginVO loginVO) {
	kmp.kakaologin(loginVO);
	}
	
	public void kakaodelete(LoginVO loginVO) {
		kmp.kakaodelete(loginVO);
	}
}
