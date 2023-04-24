package com.tit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.tit.service.GoogleOAuth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebSecurityConfigurer<WebSecurity> {
	
	@Override
    public void init(WebSecurity web) throws Exception {
        // Security configuration initialization
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // WebSecurity configuration
    }
    
    // @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HttpSecurity configuration
    	http
	        .authorizeRequests()
	        .antMatchers("/login", "/oauth2/**")	// "/login"과 "/oauth2/**" 경로에 대한 요청에 대해서는 인증 없이 접근을 허용하고, 그 외의 요청에 대해서는 인증을 필요
	        .permitAll()	// 사용자 정의 로그인 페이지 접근 권한 승인
	        .anyRequest()	
	        .authenticated()
        .and()
	        .oauth2Login()
	        .loginPage("/home.jsp")	// 로그인 페이지 경로 설정
	        .userInfoEndpoint()
//	        .userService(oauth2UserService());
    		.userService(googleOAuth2UserService()); 
    		// GoogleOAuth2UserService를 사용하여 Google OAuth2 사용자 정보를 가져옵니다
    }
    
    // ClientRegistrationRepository 인터페이스를 구현한 객체를 반환 
    // 여기서는 InMemoryClientRegistrationRepository를 사용하여 Google 클라이언트 등록 정보를 반환
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    } 
    
    // googleClientRegistration() 메서드는 lientRegistration 인터페이스를 구현한 객체를 반환합니다. Google OAuth2 인증 정보를 설정하고 있습니다.
    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
                .clientId("22641404320-61a62g9r725i4erqeqrnlhetivm8s95m.apps.googleusercontent.com")		// 본인 클라이언트 id
                .clientSecret("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")// 본인 클라이언트 secret
//                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)	// 노란줄 뜨는건 사용되지 않는것암.. 라이브러리 참고해서 수정하기위해 주석처리함
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)	// BASIC쓸지
                // 클라이언트가 자신의 인증 정보를 HTTP Basic 인증 헤더를 사용하여 보내는 방법
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)	// POST쓸지 
                // 라이언트가 클라이언트 ID 및 클라이언트 시크릿을 포함한 HTTP POST 요청을 OAuth 2.0 공급자에게 전송하여 인증
                
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUriTemplate("<redirect-uri>")		// 노란줄 뜨는건 사용되지 않는것암.. 라이브러리 참고해서 수정해야함
                .redirectUri("http://localhost:8080/login/oauth2/code/google")
                .scope("openid", "profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v3/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .clientName("Google")
                .build();
    }
    
    // oAuth2UserService() 메서드는 OAuth2UserService 인터페이스를 구현한 객체를 반환합니다. 
    // 여기서는 DefaultOAuth2UserService를 사용
    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return new DefaultOAuth2UserService();
    }
 
    @Bean
    public GoogleOAuth2UserService googleOAuth2UserService() {
        return new GoogleOAuth2UserService();
    }
    // googleOAuth2UserService() 메소드는 GoogleOAuth2UserService 객체를 반환하며, 
    // 서비스 패키지에 위치한 GoogleOAuth2UserService 클래스의 객체를 HttpSecurity 구성에서 
    // .oauth2Login().userInfoEndpoint().userService()로 전달하여 OAuth2 사용자 정보를 가져오는 데 사용
    // 따라서 googleOAuth2UserService() 메소드는 GoogleOAuth2UserService 클래스의 객체 인스턴스를 생성하고 반환하는 것입니다.
    
}
