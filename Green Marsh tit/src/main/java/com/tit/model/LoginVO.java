package com.tit.model;

public class LoginVO  {
	private String id;
    private String nickname;
    private String email;
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

 
    
    @Override
    public String toString() {
        return "KakaoUserInfoVO [id=" + id + ", email=" + email + ", nickname=" + nickname + "]";
    }
}