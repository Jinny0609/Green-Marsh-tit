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

    @Autowired
    private GoogleLoginBO googleLoginBO;
    
    @Autowired
    private GoogleProfileService googleProfileService;
    
    @Autowired
    private GoogleMapper googleMapper;
    
    @GetMapping("/oauth2/google/login")
    public String login(HttpSession session) {
        String googleAuthorizationUrl = googleLoginBO.getAuthorizationUrl(session);
        return "redirect:" + googleAuthorizationUrl;
    }

    @GetMapping("/login/oauth2/code/google")
    public String afterLogin() {
//        return "/oauth2/google/login";	
        return "googletest";	//기존 리턴
    }	//기존 있던 부분
    
    // REDIRECT_URI /oauth2/google/callback
    @RequestMapping("/oauth2/google/callback")	// 이부분 유효한지 확인
    public String callback(@RequestParam("code") String authCode, HttpSession session) throws IOException {
        String[] userProfileData = googleLoginBO.getUserProfile(authCode);
        String email = userProfileData[0];
        String name = userProfileData[1];
        String id = userProfileData[2];

        GoogleProfile userProfile = new GoogleProfile(email, name, id);
//        userProfileService.addUserProfile(userProfile);
        
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
        
        /*return "redirect:/Medical";*/
    }
    
    // 로그아웃
    @RequestMapping(value = "/oauth2/google/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		session.invalidate();
		return "redirect:/";
	}
    
    // 회원 탈퇴
    @RequestMapping(value = "/oauth2/google/acount_rm", method = { RequestMethod.GET, RequestMethod.POST })
    public String revokeAccessToken(HttpSession session) throws IOException {
 
    	String oauthToken = (String) session.getAttribute("oauthToken");
    	GoogleProfile delProfile = (GoogleProfile) session.getAttribute("UserProfile");

        System.out.println(oauthToken);
        System.out.println(delProfile);
        
//      OAuth2AccessToken oauthToken = (OAuth2AccessToken) session.getAttribute("oauthToken");
//      UserProfile userProfile = (UserProfile) session.getAttribute("UserProfile");
//  	OAuth2AccessToken UserProfile
        
        googleProfileService.delUserProfile(delProfile);
        googleLoginBO.revokeToken(oauthToken);
        session.invalidate();
        return "redirect:/";
    }
}
