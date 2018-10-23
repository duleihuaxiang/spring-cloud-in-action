package com.agan.book.config.service;


import com.agan.book.config.crypt.AuthToken;

public interface AuthService {

    /**
     * 创建登陆token（验证有效性）
     * @param
     * @return
     */
//    AuthToken auth(Login login);

//    AuthToken create(Login login, String state);


    AuthToken createAuthToken(Long userId, Long userTypeId);
    
    AuthToken createAuthToken(Long userId, Long userTypeId, Integer cycle);
    
}
