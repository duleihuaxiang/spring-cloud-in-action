package com.agan.book.config.exception.enums.dto;


import com.agan.book.config.exception.enums.base.ILabelCodeEnum;

import java.util.Arrays;

/**
 * spec
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/11/12
 * @time: 下午11:47
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/11/12 下午11:47
 */
public enum EnumDeleted implements ILabelCodeEnum<EnumDeleted, Integer> {
    NORMAL(0, "正常"),
    DELETED(1, "已删除");

    private Integer code;
    private String label;

    EnumDeleted(Integer code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public EnumDeleted codeOf(Integer code) {
        return Arrays.stream(EnumDeleted.values()).filter(v -> v.getCode().equals(code)).findFirst().get();
    }
}
