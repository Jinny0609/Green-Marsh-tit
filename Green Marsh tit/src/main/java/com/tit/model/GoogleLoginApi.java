//package com.tit.model;
//
//import com.github.scribejava.core.builder.api.DefaultApi20;
//
//public class GoogleLoginApi extends DefaultApi20{
//	protected GoogleLoginApi(){
//    }
//
//    private static class InstanceHolder{
//        private static final GoogleLoginApi INSTANCE = new GoogleLoginApi();
//    }
//    public static GoogleLoginApi instance(){
//        return InstanceHolder.INSTANCE;
//    }
//    //사용자 접근권한을 받는 주소
//    @Override
//    public String getAccessTokenEndpoint() {
//        return "https://accounts.google.com/o/oauth2/auth?client_id=22641404320-61a62g9r725i4erqeqrnlhetivm8s95m.apps.googleusercontent.com&redirect_uri=http://localhost:8080/login/oauth2/code/google&scope=https://www.googleapis.com/auth/userinfo.email&response_type=code";
//    }
//    
//    // 구글은 필요없어보임..
//	@Override
//	protected String getAuthorizationBaseUrl() {
//		return null;
//	}     
//}
//
//
//// https://accounts.google.com/o/oauth2/auth?client_id=22641404320-61a62g9r725i4erqeqrnlhetivm8s95m.apps.googleusercontent.com&redirect_uri=http://localhost:8080/login/oauth2/code/google&scope=https://www.googleapis.com/auth/userinfo.email&response_type=code