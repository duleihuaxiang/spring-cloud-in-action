package com.agan.book.config.exception.enums.http;


import com.agan.book.config.exception.enums.base.IErrorEnum;

/**
 * 401 Unauthorized
 * 当前请求需要用户验证。
 * 通常在没有登录的状态下访问一些受保护的 API 时会用到这个状态码。
 *
 * ==== RFC ====
 *
 * 当前请求需要用户验证。
 * 该响应必须包含一个适用于被请求资源的 WWW-Authenticate 信息头用以询问用户信息。
 * 客户端可以重复提交一个包含恰当的 Authorization 头信息的请求。
 * 如果当前请求已经包含了 Authorization 证书，那么401响应代表着服务器验证已经拒绝了那些证书。
 * 如果401响应包含了与前一个响应相同的身份验证询问，且浏览器已经至少尝试了一次验证，那么浏览器应当向用户展示响应中包含的实体信息，因为这个实体信息中可能包含了相关诊断信息。
 * 参见RFC 2617。
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
public interface IError401Enum<T extends Enum<T>> extends IErrorEnum<T> {

    @Override
    default Integer configHttpCode() {
        return 401;
    }

    @Override
    default String configReason() {
        return "[Unauthorized] - 当前请求未通过授权";
    }
}
