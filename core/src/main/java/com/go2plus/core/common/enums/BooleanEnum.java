package com.go2plus.core.common.enums;

/**
 * <p>User: mtwu
 * <p>Date: 13-2-7 上午11:44
 * <p>Version: 1.0
 */
public enum BooleanEnum {
    T(Boolean.TRUE, "是"), F(Boolean.FALSE, "否");

    private final Boolean value;
    private final String info;

    private BooleanEnum(Boolean value, String info) {
        this.value = value;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public Boolean getValue() {
        return value;
    }
}
