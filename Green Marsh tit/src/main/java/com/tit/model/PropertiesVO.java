package com.tit.model;

public class PropertiesVO {
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

	private String id;
	    private String nickname;
	     


	    // 생성자, getter, setter 생략


		// toString() 메서드 구현
	    @Override
	    public String toString() {
	        return "PropertiesVO{" +
	                "id='" + id + '\'' +
	                ", nickname='" + nickname + '\'' +
	                '}';
	    }
	}