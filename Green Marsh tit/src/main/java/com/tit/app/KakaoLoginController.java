package com.tit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tit.service.KakaoLoginService;

	@Controller
	public class KakaoLoginController {
		
		@Autowired
		private KakaoLoginService kakaoLoginService;
		
		@GetMapping("/oauth/kakao")
		public @ResponseBody String kakaCallback(String code) {
			// 1. 인증 서버로 부터 받은 CODE를 이용하여 액세스 토큰을 요청한다.
			String accessToken = kakaoLoginService.getAccessToken(code);
			// 응답을 콘솔과 브라우저에서 출력한다
			String userInfo = kakaoLoginService.getUserInfo(accessToken);
			return userInfo;
		}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login () {
		return "/home";
	}

	}