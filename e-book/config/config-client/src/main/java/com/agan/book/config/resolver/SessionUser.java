package com.agan.book.config.resolver;




import java.util.Date;

/**
 * specification
 *
 * session token 相关信息
 *
 * @author Spector
 * @email : qianshanshan@kuaicto.com
 * @date: 2017/11/15
 * @time: 上午11:36
 * =========================================

 * Contributors :
 * Tim Zhang - 2017/11/15 上午11:36
 */
public class SessionUser   {
    private Long userId;
    private String userName;
    private String fullName;
    private String cellphone;
    private String photo;
    private String email;
    private Date lastLoginTime;
    private String extras;



    public Long getUserId() {
        return userId;
    }

    public SessionUser setUserId(Long userId) {
        this.userId = userId;
        // 观察者模式, 设置Operator
//        this.setOperatorId(this.userId);
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public SessionUser setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
        // 观察者模式, 设置Operator
//        this.setOperatorName(this.userName);
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public SessionUser setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
        return this;
    }

    public String getCellphone() {
        return cellphone;
    }

    public SessionUser setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public SessionUser setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SessionUser setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public SessionUser setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public String getExtras() {
        return extras;
    }

    public SessionUser setExtras(String extras) {
        this.extras = extras == null ? null : extras.trim();
        return this;
    }
}
