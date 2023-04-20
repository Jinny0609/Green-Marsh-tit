package com.tit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KakaoMapper {
    // 로그인 정보 삽입
    @Insert("INSERT INTO login_info (userId, userName, userEmail) VALUES (#{userId}, #{userName}, #{userEmail})")
    int insertLoginInfo(@Param("userId") String userId, @Param("userName") String userName, @Param("userEmail") String userEmail);
}