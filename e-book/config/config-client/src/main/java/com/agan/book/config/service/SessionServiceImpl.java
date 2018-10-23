package com.agan.book.config.service;


import com.agan.book.config.crypt.AuthToken;
import com.agan.book.config.crypt.Constants;
import com.agan.book.config.resolver.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SessionServiceImpl  implements SessionService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private StoreUserFeignClient storeUserClient ;


    @Override
    public void createSession(AuthToken authToken) {
        this.resetSessionExpiryTime(authToken);
    }

    @Override
    public void createSession(AuthToken authToken, Integer cycle) {
        this.resetSessionExpiryTime(authToken, cycle);
    }

    @Override
    public void deleteSession(AuthToken authToken) {
        if (authToken == null) {
            logger.warn("authToken is null");
            return;
        }
//        this.redisService.del(buildSessionKey(authToken));
    }

    protected void resetSessionExpiryTime(AuthToken authToken) {
        this.resetSessionExpiryTime(authToken, Constants.AUTH_TOKEN_AGE_MAX);
    }
    
    protected void resetSessionExpiryTime(AuthToken authToken, Integer cycle) {
//        this.redisService.set(buildSessionKey(authToken), "ACTIVE", (cycle != null && cycle > 0 ? cycle : Constants.AUTH_TOKEN_AGE_MAX));
    }

    protected boolean isSessionInactive(AuthToken authToken) throws Exception  {
        return !this.isSessionActive(authToken);
    }

    protected boolean isSessionActive(AuthToken authToken) throws Exception {
//        return this.redisService.exists(buildSessionKey(authToken));
        return true;
    }

    protected String buildSessionKey(AuthToken authToken) {
        String sessionKey = "session-" + authToken.userId + "-" + authToken.rand;
        return sessionKey;
    }
    @Override
    public SessionUser getSession(final AuthToken authToken) throws Exception {
        if (authToken == null) {
            return null;
        }
        if (authToken.type == Constants.UserType.CLIENT_USER) {
            return this.getClientSession(authToken);
        }
        if (authToken.type == Constants.UserType.ADMIN_USER) {//erp管理员的userType由10开头
//            return this.getAdminSession(authToken);
        }
        return null;
    }

    private final SessionUser getClientSession(final AuthToken authToken) throws Exception {
        // APP Session暂不检查是否活跃
        if (authToken == null || this.isSessionInactive(authToken)) {
            return null;
        }
        //刷新redis
        this.resetSessionExpiryTime(authToken);

//        StoreUserResp storeUserResp = storeUserClient.get(authToken.userId);
        SessionUser user = new SessionUser();
        user.setUserId(authToken.userId);
//        user.setUserName(storeUserResp.getUserName());
//        //2018-05-22 fullname暂时没用，存放NickName
//        user.setFullName(storeUserResp.getNickname());
//        user.setCellphone(storeUserResp.getCellphone());
//        user.setPhoto(storeUserResp.getPhoto());
//        user.setEmail(storeUserResp.getEmail());
//        user.setLastLoginTime(storeUserResp.getLastLoginTime());

        return user;

    }

}
