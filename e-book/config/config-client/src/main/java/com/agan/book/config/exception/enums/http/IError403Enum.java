package com.agan.book.config.exception.enums.http;


import com.agan.book.config.exception.enums.base.IErrorEnum;

/**
 * 403 Forbidden
 * 服务器已经理解请求，但是拒绝执行它。与401响应不同的是，身份验证并不能提供任何帮助。
 * 通常在没有权限操作资源时(如修改/删除一个不属于该用户的资源时)会用到这个状态码。
 *
 *
 * ==== RFC ====
 *
 * 服务器已经理解请求，但是拒绝执行它。
 * 与401响应不同的是，身份验证并不能提供任何帮助，而且这个请求也不应该被重复提交。
 * 如果这不是一个 HEAD 请求，而且服务器希望能够讲清楚为何请求不能被执行，那么就应该在实体内描述拒绝的原因。
 * 当然服务器也可以返回一个404响应，假如它不希望让客户端获得任何信息。
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
public interface IError403Enum<T extends Enum<T>> extends IErrorEnum<T> {

    @Override
    default Integer configHttpCode() {
        return 403;
    }

    @Override
    default String configReason() {
        return "[Forbidden] - 服务器拒绝执行该请求";
    }
}
