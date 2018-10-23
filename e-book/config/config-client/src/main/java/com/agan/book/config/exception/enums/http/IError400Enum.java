package com.agan.book.config.exception.enums.http;


import com.agan.book.config.exception.enums.base.IErrorEnum;

/**
 * 400 Bad Request
 * 由于包含语法错误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求。
 * 通常在请求参数不合法或格式错误的时候可以返回这个状态码。
 * <p>
 * ==== RFC ====
 * <p>
 * 1、语义有误，当前请求无法被服务器理解。除非进行修改，否则客户端不应该重复提交这个请求.
 * 2、请求参数有误.
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/12
 * @time: 下午9:30
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/12 下午9:30
 */
public interface IError400Enum<T extends Enum<T>> extends IErrorEnum<T> {

    @Override
    default Integer configHttpCode() {
        return 400;
    }

    @Override
    default String configReason() {
        return "[Bad Request] - 请求参数不合法";
    }
}
