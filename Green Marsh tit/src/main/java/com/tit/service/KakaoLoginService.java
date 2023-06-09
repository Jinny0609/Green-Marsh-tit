package com.tit.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tit.model.LoginVO;

@Service
public class KakaoLoginService {

	// 토큰키를 가져오기위한 인증키 가져오기
	public String getAccessToken(String code) {
		try {
			// HttpHeaders 생성(MIME 종류)
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

			// HttpBody 생성(4개의 필수 매개변수 설정)
			MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
			body.add("grant_type", "authorization_code");
			body.add("client_id", "bb6fa36306e975c901f7c29c94043b31");
			body.add("redirect_uri", "http://localhost:8080/oauth/kakao");
			body.add("code", code);

			// HttpHeaders와 HttpBody가 설정된 HttpEntity객체 생성
			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, header);

			// RestTemplate을 이용하면 브라우저 없이 HTTP요청을 처리할 수 있다.
			RestTemplate restTemplate = new RestTemplate();

			// HTTP 요청 및 응답받기
			// 액세스 토큰 요청주소,요청 방식,요청 헤더와 바디,응답받을 타입
			ResponseEntity<String> responseEntity = restTemplate.exchange("https://kauth.kakao.com/oauth/token",
					HttpMethod.POST, requestEntity, String.class);
			// HTTP 응답 본문(body)정보 반환
			String jsonData = responseEntity.getBody();

			// JSON 데이터에서 액세스 토큰 정보만 추출
			Gson gsonObj = new Gson();
			Map<?, ?> data = gsonObj.fromJson(jsonData, Map.class);

			return (String) data.get("access_token");

		} catch (RestClientException e) {
			// HTTP 요청 및 응답 처리 중 발생할 수 있는 예외 처리
			e.printStackTrace();
			return null;
		}
	}

	// 토큰키로 회원정보 받아오기
	public LoginVO getUserInfo(String accessToken) {
		// HttpHeaders 생성(MIME 종류)
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// HttpHeader와 HttpBody를 하나의 객체에 담기 (body 정보는 생략 가능)
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(headers);

		// RestTemplate을 이용하면 브라우저 없이 HTTP 요청을 처리할 수 있다.
		RestTemplate restTemplate = new RestTemplate();

		// HTTP 요청을 POST(GET) 방식으로 실행 -> 문자열로 응답이 들어온다.
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST, requestEntity, String.class);

		// 카카오 인증 서버가 반환한 사용자 정보
		String response = responseEntity.getBody();
		System.out.println(response);

		// JSON 형식의 문자열을 Java 객체로 변환 (Jackson 라이브러리의 ObjectMapper 클래스)
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		LoginVO loginVO = null;
		try {
			loginVO = objectMapper.readValue(response, LoginVO.class);
			if (loginVO.getProperties() != null) {
				loginVO.setId(loginVO.getId());
				loginVO.setNickname(loginVO.getProperties().getNickname());
				loginVO.setSns("kakao");
			}
			if (loginVO.getKakao_account() != null) {
				loginVO.setEmail(loginVO.getKakao_account().getEmail());
				loginVO.setSns("kakao");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 변환된 모델 객체 반환
		return loginVO;
	}

	// 토큰 만료시 로그아웃 처리
	public void kakaologout(String accessToken) {
		try {
			// HttpHeaders 생성(MIME 종류)
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + accessToken);

			// HttpHeader와 HttpBody를 하나의 객체에 담기 (body 정보는 생략 가능)
			HttpEntity<?> requestEntity = new HttpEntity<>(headers);

			// RestTemplate을 이용하면 브라우저 없이 HTTP 요청을 처리할 수 있다.
			RestTemplate restTemplate = new RestTemplate();

			// HTTP 요청을 POST 방식으로 실행 -> 문자열로 응답이 들어온다.
			ResponseEntity<String> responseEntity = restTemplate.exchange("https://kapi.kakao.com/v1/user/logout",
					HttpMethod.POST, requestEntity, String.class);

			// HTTP 응답 본문(body)정보 반환
			String response = responseEntity.getBody();
			System.out.println(response);

		} catch (RestClientException e) {
			// HTTP 요청 및 응답 처리 중 발생할 수 있는 예외 처리
			e.printStackTrace();
		}
	}
	
	// 회원탈퇴 처리(동의화면 다시 뛰우기,토큰만료)
	public void kakaoremove(String accessToken) {
		try {
			// HttpHeaders 생성(MIME 종류)
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + accessToken);

			// HttpHeader와 HttpBody를 하나의 객체에 담기 (body 정보는 생략 가능)
			HttpEntity<?> requestEntity = new HttpEntity<>(headers);

			// RestTemplate을 이용하면 브라우저 없이 HTTP 요청을 처리할 수 있다.
			RestTemplate restTemplate = new RestTemplate();

			// HTTP 요청을 POST 방식으로 실행 -> 문자열로 응답이 들어온다.
			ResponseEntity<String> responseEntity = restTemplate.exchange("https://kapi.kakao.com/v1/user/unlink",
					HttpMethod.POST, requestEntity, String.class);

			// HTTP 응답 본문(body)정보 반환
			String response = responseEntity.getBody();
			System.out.println(response);

		} catch (RestClientException e) {
			// HTTP 요청 및 응답 처리 중 발생할 수 있는 예외 처리
			e.printStackTrace();
		}
	}
}