package com.tit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tit.mapper.NaverMapper;
import com.tit.model.NaverVO;

@Service
public class NaverLoginServiceImpl implements NaverLoginService {
	
	@Autowired
	private NaverMapper naverMapper;
	
	public void naverlogin(NaverVO naverVO) {
		naverMapper.naverlogin(naverVO);
	}
	public void naverlogout(NaverVO naverVO){
		naverMapper.naverlogout(naverVO);
	}
}
