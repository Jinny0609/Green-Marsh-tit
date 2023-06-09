package com.tit.app;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tit.mapper.KakaoMapper;
import com.tit.model.LoginVO;
import com.tit.service.KakaoLoginService;
import com.tit.service.KakaoLogintoService;

	@Controller
	public class KakaoLoginController {
		
		@Autowired
		private KakaoLoginService kakaoLoginService;
		
		@Autowired
		private KakaoLogintoService kls;
		
		@Autowired
	    private KakaoMapper kakaoMapper;
		
		// 인증키&토큰키&로그인처리
		@GetMapping("/oauth/kakao")
		public String kakaCallback(String code, HttpSession session) {
			// 인증 서버로 부터 받은 CODE를 이용하여 액세스 토큰을 요청한다.
			String accessToken = kakaoLoginService.getAccessToken(code);
			// 응답을 콘솔과 브라우저에서 출력한다
			LoginVO loginVO = kakaoLoginService.getUserInfo(accessToken);
			
			// email 값을 조회하여 이미 존재하는 경우 로그인 처리, 그렇지 않으면 회원가입 처리
	        int count = kakaoMapper.checkID(loginVO.getId());
	        if (count > 0) {
	            // 이미 등록된 이메일인 경우 로그인 처리
	            // 로그인 처리 코드 작성
	        	session.setAttribute("usernickname", loginVO.getNickname());
				session.setAttribute("accessToken", accessToken);
				session.setAttribute("loginVO", loginVO);
				String snsid = kakaoMapper.checkSns(loginVO);
				session.setAttribute("Snsid", snsid);
				System.out.println(loginVO);
	            return "redirect:/Medical";
	        } else {
	            // 새로운 이메일인 경우 회원가입 처리
	            kls.kakaologin(loginVO); //DB에 회원 정보를 저장 loginVO모델에 담아서 전달
	            session.setAttribute("loginVO", loginVO);
				String snsid = kakaoMapper.checkSns(loginVO);
				session.setAttribute("Snsid", snsid);
				session.setAttribute("usernickname", loginVO.getNickname());
	            return "redirect:/MemberJoin";
	        }
	
		}


/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login () {
		return "/home";
	}
	*/
	@RequestMapping(value = "/Medical", method = RequestMethod.GET)
	public String mainhome () {
		return "/Medical";
	}
	
	// 로그아웃 메소드
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
	    String accessToken = (String)session.getAttribute("accessToken");
	    LoginVO loginInfo = (LoginVO)session.getAttribute("loginInfo");
	    
	    if(loginInfo != null && "kakao".equals(loginInfo.getSns())){ // sns 속성 비교
	        if(accessToken != null && !"".equals(accessToken)){
	            kakaoLoginService.kakaologout(accessToken);
	        }
	    }

	    session.invalidate();
	    return "redirect:/";
	}
	
	  
	  // 회원탈퇴 메소드
	  @RequestMapping(value="/remove")
	    public String remove(HttpSession session) {
	        String accessToken = (String)session.getAttribute("accessToken");

	        if(accessToken != null && !"".equals(accessToken)){
	        	LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
	        	kls.kakaodelete(loginVO);
	        	kakaoLoginService.kakaoremove(accessToken);
	        	session.invalidate();
	        }else{
	            System.out.println("access_Token is null");
	            //return "redirect:/";
	        }
	        //return "index";
	        return "redirect:/";
	    }

	}