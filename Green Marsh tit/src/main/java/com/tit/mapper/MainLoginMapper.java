package com.tit.mapper;

import java.util.ArrayList;

import com.tit.model.MainLoginVO;

public interface MainLoginMapper {
	
	public void memberjoin(MainLoginVO mainloginVO);
	public ArrayList<MainLoginVO> memberlogin(MainLoginVO mainloginVO);
	public void memberlogout(String email);

}
