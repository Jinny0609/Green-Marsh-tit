package com.tit.model;

public class NaverVO {
	private String id;
	private String nickname;
	private String email;
	private String sns;
	
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
		this.sns = sns;
	}
	
	@Override
	public String toString() {
		return "NaverVO [id=" + id + ", nickname=" + nickname + ", email=" + email + ", sns=" + sns + "]";
	}
	
	/*삭제*/
	
}
