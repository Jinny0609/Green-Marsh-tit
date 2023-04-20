package com.tit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tit.model.LoginVO;
import com.tit.service.KakaoLoginService;
import com.tit.service.KakaoLogintoService;

	@Controller
	public class KakaoLoginController {
		
		@Autowired
		private KakaoLoginService kakaoLoginService;
		
		@Autowired
		private KakaoLogintoService kls;
		
		@GetMapping("/oauth/kakao")
		public String kakaCallback(String code, Model model) {
			// 인증 서버로 부터 받은 CODE를 이용하여 액세스 토큰을 요청한다.
			String accessToken = kakaoLoginService.getAccessToken(code);
			// 응답을 콘솔과 브라우저에서 출력한다
			LoginVO loginVO = kakaoLoginService.getUserInfo(accessToken);
			model.addAttribute("loginVO", loginVO);
			System.out.println(loginVO);
			kls.kakaologin(loginVO);
	
			// home.jsp 페이지로 이동한다.
			return "redirect:/MainPage";
		}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login () {
		return "/home";
	}
	
	@RequestMapping(value = "/MainPage", method = RequestMethod.GET)
	public String mainhome () {
		return "/MainPage";
	}

	}