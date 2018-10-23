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
public class APIException extends FrameworkException {
    /******* Fields Area *******/
    /******* Construction Area *******/

    /**
     * init error message
     *
     * @param errorEnum IErrorEnum
     */
    public APIException(IErrorEnum errorEnum) {
        super(errorEnum);
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    @Override
    public String toString() {
        return "APIException{" +
                "errorEnum=" + super.errorEnum +
                '}';
    }
}
