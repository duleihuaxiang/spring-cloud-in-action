package com.agan.book.config.vo.req;

//import org.apache.commons.lang3.StringUtils;

public class Login {

    private Long userId;
    private String userName;
    private String password;

    /*微信登录专用*/
    private String openId;


    private boolean remember = false;
    
    public boolean validate() {
//    	return StringUtils.isNotBlank(userName)
//    			&& StringUtils.isNotBlank(password)
//    			&& (!userName.contains("\""))
//    			&& (!userName.contains("'"));

    	return true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
