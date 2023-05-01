package com.tit.model;

public class MainLoginVO {
	
	private String id;
	private String nickname;
	private String email;
	private String password;
	private String sns;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		this.sns = "basic";
	}
	
	@Override
	public String toString() {
		return "MainInfoVO [id=" + id + ", email=" + email + ", nickname=" + nickname + ", sns=" + sns + "]";
	}

}
