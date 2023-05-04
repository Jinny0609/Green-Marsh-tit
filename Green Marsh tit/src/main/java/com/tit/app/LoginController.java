package com.tit.app;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tit.mapper.MainLoginMapper;
import com.tit.model.MainLoginVO;
import com.tit.service.MainLoginService;


@Controller
public class LoginController {

	@Autowired
	private MainLoginService mainloginservice;
	
	@Autowired
	private MainLoginMapper mainmapper;
	
	// 회원가입
	@RequestMapping(value = "/MainMemberJoin", method = RequestMethod.POST)
	public String memberjoin (MainLoginVO mainloginVO, HttpSession session) {
		mainloginservice.memberjoin(mainloginVO);
		session.setAttribute("mainloginVO", mainloginVO);
		String snsid = mainmapper.checkSns(mainloginVO);
		session.setAttribute("Snsid", snsid);
		session.setAttribute("usernickname", mainloginVO.getNickname());
		return "redirect:/MemberJoin";
	}
	
	// 로그인 (예외처리 완료)
	@RequestMapping(value = "/MainMemberlogin", method = RequestMethod.POST)
	public String memberlogin (MainLoginVO mainloginVO, HttpSession session) {
		ArrayList<MainLoginVO> loginList = mainloginservice.memberlogin(mainloginVO);
		try {
		    if (loginList.size() > 0 && loginList.get(0).getEmail() != null && "basic".equals(loginList.get(0).getSns())) {
		        session.setAttribute("usernickname", loginList.get(0).getNickname());
		        session.setAttribute("Loginlist", loginList);
		        String snsid = loginList.get(0).getSns();
		        session.setAttribute("Snsid", snsid);
		        return "redirect:/Medical";
		    } else {
		        return "redirect:/";
		    }
		} catch (IndexOutOfBoundsException e) {
		    // 예외 처리 코드 작성
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
	
	//비밀번호 찾기
	@RequestMapping(value = "/findpassword", method = RequestMethod.GET)
		public String search() {
			return "findpassword";
		}
	
	@RequestMapping(value = "/findpassword", method = RequestMethod.POST)
	public String findPassword(@RequestParam("email") String email, Model model) {
	    MainLoginVO mainLoginVO = new MainLoginVO();
	    mainLoginVO.setEmail(email);
	    mainLoginVO.setSns("basic");

	    String password = mainmapper.checkPasswordByEmailAndSns(mainLoginVO);

	    if (password != null) {
	        model.addAttribute("password", password);
	        System.out.println(password);	// 출력 잘 됨
	        model.addAttribute("viewName", "passwordPopup"); // 뷰 이름 추가
	    } else {
	        model.addAttribute("errorMessage", "이메일이 일치하지 않거나 SNS 계정입니다.");
	        model.addAttribute("viewName", "error"); // 뷰 이름 추가
	    }
	    return "findpassword";
	}
}
