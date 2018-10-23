package com.agan.book.config.service;

import com.agan.book.config.crypt.AuthToken;
import com.agan.book.config.crypt.Constants;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {


    @Override
    public AuthToken createAuthToken(Long userId, Long userTypeId) {

        return createAuthToken(userId, userTypeId, Constants.AUTH_TOKEN_AGE_MAX);

    }
    
    @Override
    public AuthToken createAuthToken(Long userId, Long userTypeId, Integer cycle) {
        final long now = System.currentTimeMillis();
        final long expiry = now + (cycle != null && cycle > 0 ? Long.valueOf(cycle) : 0) * 1000;
        final AuthToken authToken = new AuthToken(userId, userTypeId, now, expiry, Math.random()+"");
        return authToken;
    }
}
