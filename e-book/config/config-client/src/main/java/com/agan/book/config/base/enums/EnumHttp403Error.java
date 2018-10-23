package com.agan.book.config.base.enums;


import com.agan.book.config.exception.enums.http.IError403Enum;

/**
 * sale-order-module
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/16
 * @time: 下午4:01
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/16 下午4:01
 */
public enum EnumHttp403Error implements IError403Enum<EnumHttp403Error> {
    ATTR_USER_NAME_NOT_FOUND(403001, "指定 属性模板未找到"),

    ;


    private Integer code;
    private String message;

    EnumHttp403Error(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }


}
