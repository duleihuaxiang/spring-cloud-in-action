package com.agan.book.config.exception.enums.base;

/**
 * <p>
 * Description :
 * 适用于自定义Code(Integer)值 枚举类型, 需要提供1参构造函数
 * =========================
 * Enum :
 * FIRST(1),
 * SECOND(2)
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
public interface ICodeEnum<T extends Enum<T>, C> {

    C getCode();

    T codeOf(C code);

    /**
     * 根据code获得枚举对象
     * @param instance Enum
     * @param code generic type code
     * @return ICodeEnum
     */
    static ICodeEnum codeOf(Enum instance, Object code) {
        ICodeEnum sub = (ICodeEnum) instance;
        return (ICodeEnum) sub.codeOf(code);
    }
}
