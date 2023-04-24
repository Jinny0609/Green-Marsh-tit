package com.tit.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class GoogleOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    
	@Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        // OAuth2 공급자로부터 사용자 정보를 가져와서 OAuth2User 객체를 반환
        OAuth2User user = new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                userRequest.getAdditionalParameters(), "name");

        // 가져온 사용자 정보를 출력
        System.out.println(user.getAttributes());    // 코드는 테스트용으로 작성한 코드, 추후 제거해야함.

        return user;
	}

	public static Object googleOauth2User() {
		return null;
	}

    // loadUser() 메서드에서는 DefaultOAuth2User 객체를 생성하고, 이를 반환합니다. 이때 SimpleGrantedAuthority 객체를 이용하여 ROLE_USER 권한을 부여하고, 

	// userRequest 객체에서 받아온 추가적인 파라미터를 OAuth2User 객체에 저장
    
	// 가져온 사용자 정보를 출력 코드는 테스트용으로 작성한 코드, 추후 제거해야함.
    
}
