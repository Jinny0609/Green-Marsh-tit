package com.tit.mapper;

import com.tit.model.LoginVO;

public interface KakaoMapper {
    // 로그인 정보 삽입
	public void kakaologin(LoginVO loginVO);
	public int checkEmail(String email);
	public String checkSns(LoginVO loginVO);
	public void kakaodelete(LoginVO loginVO);
	
}