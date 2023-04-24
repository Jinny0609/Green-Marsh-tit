package com.tit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tit.security.SecurityConfig;
import com.tit.service.GoogleOAuth2UserService;

@Controller
//@RestController
public class GoogleLoginController {
	
	@Autowired
    private GoogleOAuth2UserService googleOauth2UserVO;

	
	private ClientRegistrationRepository clientRegistrationRepository;
	
	@GetMapping("/google-client-id")
	public String getGoogleClientId() {
		ClientRegistration registration = clientRegistrationRepository.findByRegistrationId("google");
		return registration.getClientId();
	}
	
    // 로그인 페이지
    @GetMapping("/login")
    public String showLoginPage(Model model, GoogleOAuth2UserService googleOauth2User) {
        if (googleOauth2User != null) {
            
            return "redirect:/home";
        }
        // 토큰 요청위치 파악.. 
        
        model.addAttribute("googleAuthorizationUri", googleOauth2UserVO);
        return "login";
    }
    
    // 인증키&토큰키&로그인처리
	@GetMapping("/login/oauth2/code/google")
	public String googleCallback(SecurityConfig configure) {
		System.out.println("토큰키값 반환하기");
		return "/home"; 
		
	}
	
	
	
}
