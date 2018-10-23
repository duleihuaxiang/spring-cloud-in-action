package com.agan.book.config.crypt;

/**
 * Created by Administrator on 2017/7/18.
 */
public class Constants {

    /**
     * AuthToken 活跃时间（即自动续期最大间隔）（半个小时）
     */
    public static final int AUTH_TOKEN_AGE_ACTIVE = 1800;

    /**
     * AuthToken 最长过期时间（100天）
     */
    public static final int AUTH_TOKEN_AGE_MAX = 100 * 24 * 3600;


    public static final String AUTH_TOKEN_NAME = "_MCH_AT";

    /**
     * token默认名称
     */
    public static final String AUTH_TOKEN_NAME_DEFAULT = "user_token";

    /**
     * 用户类型
     */
    public static class UserType{


        /**
         * 商城用户
         * */
        public static final Long CLIENT_USER = 1L;


        /**
         * 运营用户
         * */
        public static final Long ADMIN_USER = 2L;
    }




}
