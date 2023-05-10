package com.tit.app;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tit.mapper.GoogleMapper;
import com.tit.model.GoogleProfile;
import com.tit.service.GoogleLoginBO;
import com.tit.service.GoogleProfileService;

@Controller
public class GoogleLoginController {

	// GoogleLoginBO, GoogleProfileService, GoogleMapper @Autowired를 이용해 의존성 주입
	// Google OAuth2 인증, Google 프로필 정보를 DB에 CRUD 작업, Google 프로필 정보를 DB에 저장하는 데 사용
    @Autowired
    private GoogleLoginBO googleLoginBO;
    
    @Autowired
    private GoogleProfileService googleProfileService;
    
    @Autowired
    private GoogleMapper googleMapper;
    
    // GET /oauth2/google/login 요청이 들어오면, GoogleLoginBO를 이용하여 구글 로그인 URL을 생성
    // 이를 포함한 redirect 응답을 보냄 이 과정을 통해 사용자는 구글 계정으로 로그인
    @GetMapping("/oauth2/google/login")
    public String login(HttpSession session) {
        String googleAuthorizationUrl = googleLoginBO.getAuthorizationUrl(session);
        return "redirect:" + googleAuthorizationUrl;
    } 
    
    // REDIRECT_URI /oauth2/google/callback
    // GET /oauth2/google/callback 요청이 들어오면, GoogleLoginBO를 이용하여 사용자의 access token을 받아
    // getUserProfile 메소드를 이용하여 access token으로부터 사용자의 이메일, 이름, ID 등의 정보를 받아옵니다. 
    // 받아온 정보를 바탕으로 GoogleProfile 객체를 생성
    @RequestMapping("/oauth2/google/callback")	// 이부분 유효한지 확인
    public String callback(@RequestParam("code") String authCode, HttpSession session) throws IOException {
        String[] userProfileData = googleLoginBO.getUserProfile(authCode);
        String email = userProfileData[0];
        String name = userProfileData[1];
        String id = userProfileData[2];

        GoogleProfile userProfile = new GoogleProfile(email, name, id);
        
        int count = googleProfileService.findUserProfileByEmail(userProfile.getEmail());
        if(count > 0) {
        	session.setAttribute("UserProfile", userProfile);
        	session.setAttribute("oauthToken", authCode);
            session.setAttribute("googleNickname", name);
            String snsid = googleMapper.checksns(email);
            session.setAttribute("Snsid", snsid);
            System.out.println(snsid);	//test
            return "redirect:/Medical";
        } else {
        	googleProfileService.addUserProfile(userProfile);
            session.setAttribute("UserProfile", userProfile);
            session.setAttribute("googleNickname", name);
            String snsid = googleMapper.checksns(email);
            session.setAttribute("Snsid", snsid);
            return "redirect:/MemberJoin";
        }
    }
    
    // 로그아웃
    // /oauth2/google/logout 요청이 들어오면, 세션을 초기화하고, 
    // 홈 화면으로 redirect 합니다 이 과정을 통해 사용자는 로그아웃 할 수 있다.
    @RequestMapping(value = "/oauth2/google/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		session.invalidate();
		return "redirect:/";
	}
    
    // 회원 탈퇴
    // GET /oauth2/google/account_rm 요청이 들어오면 
    // GoogleProfileService의 delUserProfile 메소드를 호출하여 DB에서 해당 사용자 정보를 삭제
    // GoogleLoginBO의 revokeToken 메소드를 호출하여 access token을 폐기합니다. 세션을 초기화하고, 홈 화면으로 redirect 한다.
    // 이 과정을 통해 사용자는 회원 탈퇴를 할 수 있다.
    @RequestMapping(value = "/oauth2/google/acount_rm", method = { RequestMethod.GET, RequestMethod.POST })
    public String revokeAccessToken(HttpSession session) throws IOException {
 
    	String oauthToken = (String) session.getAttribute("oauthToken");
    	GoogleProfile delProfile = (GoogleProfile) session.getAttribute("UserProfile");

        System.out.println(oauthToken);
        System.out.println(delProfile);
        
        googleProfileService.delUserProfile(delProfile);
        googleLoginBO.revokeToken(oauthToken);
        session.invalidate();
        return "redirect:/";
    }
}
