package com.agan.book.config.exception.enums.http;


import com.agan.book.config.exception.enums.base.IErrorEnum;

/**
 *
 * 503 Overload (超载)
 * 当服务器流量过高时, 我们有时需要服务降级, 服务熔断.
 * 此时我们可以告诉客户端 503 编码告知.
 *
 * ==== RFC ====
 *
 * 由于临时的服务器维护或者过载，服务器当前无法处理请求。
 * 这个状况是临时的，并且将在一段时间以后恢复。
 * 如果能够预计延迟时间，那么响应中可以包含一个 Retry-After 头用以标明这个延迟时间。
 * 如果没有给出这个 Retry-After 信息，那么客户端应当以处理500响应的方式处理它。 　　
 * 注意：503状态码的存在并不意味着服务器在过载的时候必须使用它。
 * 某些服务器只不过是希望拒绝客户端的连接。
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
public interface IError503Enum<T extends Enum<T>> extends IErrorEnum<T> {

    @Override
    default Integer configHttpCode() {
        return 503;
    }

    @Override
    default String configReason() {
        return "[Overload] - 由于临时的服务器维护或者过载, 服务器当前无法处理请求.";
    }
}
