package com.tit.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginVO  {
// 유저 아이디
 private String userid;
// 유저 비빌번호
 private String userpw;
// 유저 닉네임
 private String nickname;
 
 @Override
	public String toString() {
		return "KakaoLoginModel [userid=" + userid + ", userpw=" + userpw + ", nickname=" + nickname + "]";
	}
 
}
