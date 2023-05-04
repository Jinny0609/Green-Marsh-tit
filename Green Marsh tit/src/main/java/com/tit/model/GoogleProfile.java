package com.tit.model;

public class GoogleProfile {
	private String email;
	private String nickname;
	private String id;
	private String sns;
	
	public GoogleProfile() {
    }

    public GoogleProfile(String email, String nickname, String id) {
        this.email = email;
        this.nickname = nickname;
        this.id = id;
        this.sns = "google";
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	@Override
	public String toString() {
		return "UserProfile [email=" + email + ", nickname=" + nickname + ", sns=" + sns + "]";
	}
    
}
