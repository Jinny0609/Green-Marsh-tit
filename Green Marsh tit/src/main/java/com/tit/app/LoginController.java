package com.tit.app;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tit.model.MainLoginVO;
import com.tit.service.MainLoginService;


@Controller
public class LoginController {

	@Autowired
	private MainLoginService mainloginservice;
	
	// 회원가입
	@RequestMapping(value = "/MainMemberJoin", method = RequestMethod.POST)
	public String memberjoin (MainLoginVO mainloginVO) {
		mainloginservice.memberjoin(mainloginVO);
		return "redirect:/";
	}
	
	// 로그인
	@RequestMapping(value = "/MainMemberlogin", method = RequestMethod.POST)
	public String memberlogin (MainLoginVO mainloginVO, HttpSession session) {
		ArrayList<MainLoginVO> loginList = mainloginservice.memberlogin(mainloginVO);
		System.out.println(loginList);
		if(loginList.get(0).getEmail() != null && "basic".equals(loginList.get(0).getSns())) {
			session.setAttribute("usernickname", loginList.get(0).getNickname());
			session.setAttribute("Loginlist", loginList);
			String snsid = loginList.get(0).getSns();
			session.setAttribute("Snsid", snsid);
			return "redirect:/Medical";
		} else {
			return "redirect:/";
		}
	}
	
	// 메인서비스 로그아웃
	@RequestMapping(value = "/MainMemberlogout", method = RequestMethod.GET)
	public String memberlogout (HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 메인서비스 회원탈퇴
	@RequestMapping(value = "/MainMemberDelete", method = RequestMethod.GET)
	public String memberDelete (MainLoginVO mainloginVO, HttpSession session) {
		ArrayList<MainLoginVO> loginList = (ArrayList<MainLoginVO>)session.getAttribute("Loginlist");
		String email = loginList.get(0).getEmail();
		mainloginservice.memberlogout(email);
		session.invalidate();
		System.out.println("회원탈퇴 완료");
		return "redirect:/";
	}
	
}
