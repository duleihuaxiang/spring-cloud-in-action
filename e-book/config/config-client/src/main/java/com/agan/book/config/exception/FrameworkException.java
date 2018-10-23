package com.agan.book.config.exception;


import com.agan.book.config.exception.enums.base.IErrorEnum;

/**
 * smart-spring-boot-web
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/12
 * @time: 上午11:18
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/12 上午11:18
 */
public abstract class FrameworkException extends Exception {
    /******* Fields Area *******/
    protected IErrorEnum errorEnum;
    /******* Construction Area *******/

    /**
     * init error message
     *
     * @param errorEnum IErrorEnum
     */
    public FrameworkException(IErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    /******* GetSet Area ******/
    public IErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public FrameworkException setErrorEnum(IErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
        return this;
    }

    @Override
    public String toString() {
        return "FrameworkException{" +
                "errorEnum=" + errorEnum +
                '}';
    }

    /******* Method Area *******/


}
