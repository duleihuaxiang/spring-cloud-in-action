package com.agan.book.config.service;


import com.agan.book.config.crypt.AuthToken;
import com.agan.book.config.resolver.SessionUser;

public interface SessionService  {

    void createSession(AuthToken authToken);
    
    void createSession(AuthToken authToken, Integer cycle);

    /**
     * 清除session
     */
    void deleteSession(AuthToken authToken);

    SessionUser getSession(AuthToken authToken) throws Exception;
}
