package com.tit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverVO {
	private String id;
	private String nickname;
	private String email;
	private String sns;
	private responseVO response;
	
	public responseVO getResponse() {
		return response;
	}
	public void setResponse(responseVO response) {
		this.response = response;
	}
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
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = "naver";
	}
	
	@Override
	public String toString() {
		return "NaverVO [id=" + id + ", nickname=" + nickname + ", email=" + email + ", sns=" + sns + "]";
	}
	
	/*삭제*/
	
}
