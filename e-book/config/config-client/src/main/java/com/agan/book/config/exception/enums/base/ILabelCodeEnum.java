package com.agan.book.config.exception.enums.base;

/**
 * <p>
 * Description :
 * 适用于这种类型, 需要提供2参构造函数
 * =========================
 * Enum :
 * FIRST("First", 1),
 * SECOND("Second", 2),
 *
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
public interface ILabelCodeEnum<T extends Enum<T>, C> extends ICodeEnum<T, C> {

    String getLabel();

}
