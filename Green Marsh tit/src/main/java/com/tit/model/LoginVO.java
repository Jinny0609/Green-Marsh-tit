package com.tit.model;

public class LoginVO {
	private String id;
	private String nickname;
	private String email;
	private String sns;
	private PropertiesVO properties;
	private KakaoAccountVO kakao_account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PropertiesVO getProperties() {
		return properties;
	}

	public KakaoAccountVO getKakao_account() {
		return kakao_account;
	}

	public void setProperties(PropertiesVO properties) {
		this.properties = properties;
	}

	public void setKakao_account(KakaoAccountVO kakao_account) {
		this.kakao_account = kakao_account;
	}

	public String getSns() { // column getter 메소드 추가
		return sns;
	}

	public void setSns(String sns) { // column setter 메소드 추가
		this.sns = "kakao";
	}

	@Override
	public String toString() {
		return "KakaoUserInfoVO [id=" + id + ", email=" + email + ", nickname=" + nickname + ", sns=" + sns + "]";
	}
}