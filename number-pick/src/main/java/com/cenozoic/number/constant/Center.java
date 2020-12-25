package com.cenozoic.number.constant;/**
 * <p>
 *
 * @author xucaifeng
 * @since 2020-12-20
 **/

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-20
 **/
public enum Center {

    CENTER01(1, "黑龙江中二院"),

    CENTER02(2, "深圳宝安医院"),

    CENTER03(3, "北京西苑医院");

    private Integer centerId;
    private String center;

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    Center(Integer centerId, String center) {
        this.centerId = centerId;
        this.center = center;
    }
}
