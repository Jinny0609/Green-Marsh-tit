package com.tit.service;

import java.util.ArrayList;

import com.tit.model.MainLoginVO;


public interface MainLoginService {
	public void memberjoin(MainLoginVO mainloginVO);
	public ArrayList<MainLoginVO> memberlogin(MainLoginVO mainloginVO);
	public void memberlogout(String email);
	public String checkPasswordByEmailAndSns(MainLoginVO mainLoginVO);
}
