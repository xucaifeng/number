package com.cenozoic.number.constant;

public enum DatePatternEnum {
    yyyy_MM_dd("yyyy-MM-dd"),
    yyyyMMdd("yyyyMMdd"),
    yyyy年MM月dd日("yyyy年MM月dd日"),
    yyyy__MM__dd("yyyy/MM/dd"),

    yyyyMMddHHmmssS("yyyyMMddHHmmssS"),
    yyyyMMdd_HHmmssSSS("yyyyMMdd HHmmssSSS"),
    yyyyMMddHHmmss("yyyyMMddHHmmss"),
    yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
    yyyy年MM月dd日_HH时mm分("yyyy年MM月dd日 HH时mm分"),
    yyyy_MM_dd_23_59_59("yyyy-MM-dd 23:59:59"),
    yyyy_MM_dd_00_00_00("yyyy-MM-dd 00:00:00"),
    yyyy年MM月dd日_HH_mm_ss("yyyy年MM月dd日 HH:mm:ss"),
    yyyy_MM_dd_HH_00_00("yyyy-MM-dd HH:00:00"),
    yyyy_MM_ddTHH_mm_ss_SSSZ("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
    yyyyMMddHHmmssSSS("yyyyMMddHHmmssSSS"),


    yyyyMM("yyyyMM"),
    MMdd("MMdd"),
    HH_mm_ss("HH:mm:ss"),
    HHmmss("HHmmss"),







    ;
    private String pattern;

    DatePatternEnum(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
