package com.tit.mapper;

import com.tit.model.UserProfile;

public interface UserProfileMapper {
    void insertUserProfile(UserProfile userProfile);
    int findByEmail(String email);
    
    void delUserProfile(UserProfile userProfile1);
    // int로 설정한 이유는 삭제된 행의 수를 반환하기 위해서입니다.
    // MyBatis에서는 INSERT, UPDATE, DELETE와 같은 쓰기 작업을 수행할 때 영향을 받은 행의 수를 반환합니다. 이렇게 함으로써, 호출자가 해당 작업이 실제로 수행되었는지 확인할 수 있습니다.
    // 예를 들어, deleteUserProfile 메소드를 호출한 후 반환된 값이 1이면 한 명의 사용자가 삭제된 것을 알 수 있습니다. 반면, 반환된 값이 0이면 이메일 주소와 일치하는 사용자가 없어 삭제되지 않았음을 알 수 있습니다. 
    // 이를 통해 오류를 처리하거나 로깅 목적으로 사용할 수 있습니다.
    String checksns(String email);
}