package com.tit.app;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.tit.mapper.NaverMapper;
import com.tit.model.NaverVO;
import com.tit.service.NaverLoginBO;
import com.tit.service.NaverLoginService;

@Controller
public class NaverController {
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	private String snsId = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@Autowired
	private NaverLoginService nls;

	@Autowired
	private NaverMapper navermapper;

	/* 삭제 */
	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		// 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		model.addAttribute("url", naverAuthUrl);

		// 생성한 인증 URL을 View로 전달
		return "home";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/oauth2/naver/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, HttpSession session, @RequestParam String code, @RequestParam String state)
			throws IOException {
		System.out.println("여긴callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);

		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		System.out.println(apiResult);
		
		// JSON 문자열을 NaverVO 객체로 변환한다.
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		NaverVO naverVO = null;
		try {
			naverVO = mapper.readValue(apiResult, NaverVO.class);
			if (naverVO.getResponse() != null) {
				naverVO.setId(naverVO.getResponse().getId());
				naverVO.setNickname(naverVO.getResponse().getNickname());
				naverVO.setEmail(naverVO.getResponse().getEmail());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(naverVO);
		int count = navermapper.checkEmail(naverVO.getEmail());
		if (count > 0) { // 로그인
			// 세션에 NaverVO 객체를 저장한다.
			session.setAttribute("naverVO", naverVO);
			session.setAttribute("oauthToken", oauthToken);
			/* 네이버 로그인 성공 페이지 View 호출 */
			return "redirect:/naverSuccess";
		} else { // 회원가입
			nls.naverlogin(naverVO); // DB로 회원정보 전달
			return "redirect:/MemberJoin";
		}

	}

	// 회원탈퇴
	@RequestMapping(value = "/oauth2/naver/logoutin", method = { RequestMethod.GET, RequestMethod.POST })
	public String logoutin(HttpSession session) throws IOException {
		OAuth2AccessToken oauthToken = (OAuth2AccessToken) session.getAttribute("oauthToken");
		naverLoginBO.logoutin(oauthToken);
		session.invalidate();
		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping(value = "/oauth2/naver/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		session.invalidate();
		return "redirect:/";
	}

	// 로그인됬을떄 이동
	@RequestMapping(value = "/naverSuccess", method = { RequestMethod.GET, RequestMethod.POST })
	public String success() {
		return "naverSuccess";
	}
	 // 회원가입 성공 (로그인페이지로 이동)
	@RequestMapping(value = "/MemberJoin", method = { RequestMethod.GET, RequestMethod.POST })
	public String MemberJoin() {
		return "MemberJoin";
	}
}
