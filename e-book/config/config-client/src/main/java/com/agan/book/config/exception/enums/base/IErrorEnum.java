package com.agan.book.config.exception.enums.base;

/**
 * <p>
 * Description :
 * 适用于系统异常
 * =========================
 * Enum :
 * <p>
 * <p>
 * Creator :
 * Sudao @ Tim Zhang
 * Email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * Date: 2017/7/18
 * Time: 上午10:11
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/7/18 上午10:11
 */
public interface IErrorEnum<T extends Enum<T>> extends ICodeEnum<T, Integer> {

    /**
     * 配置 reason
     * 用于错误理由
     * @return
     */
    String configReason();

    /**
     * 配置 code
     * 用于错误代码
     * @return
     */
    Integer configHttpCode();

    /**
     * 获得 reason
     * JDK 1.8 新增 default.
     * @return
     */
    default String getReason() {
        return this.configReason();
    }

    /**
     * 获得 http code
     * JDK 1.9 新增 default.
     * @return
     */
    default Integer getHttpCode() {
        return this.configHttpCode();
    }


    /**
     * 获得 message
     * 用于错误描述
     * @return
     */
    String getMessage();

    /**
     * not need this method
     * @param code Integer
     * @return null
     */
    @Override
    default T codeOf(Integer code) {
        return null;
    }
}
