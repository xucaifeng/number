package com.cenozoic.number.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-21
 **/
@Data
public class Number {

    @Id
    private Integer id;

    /**
     * 中心编号 1 黑龙江中二院，2 深圳宝安医院，3 北京西苑医院
     */
    private Integer centerId;

    private String center;

    /**
     * 布氏分期 1 痉挛期，2 恢复期
     */
    private Integer brinellId;

    private String brinellPeriods;

    /**
     * 病例序号
     */
    private String caseNum;

    /**
     * 病例随机编号
     */
    private Integer randomNum;

    /**
     * 干预方法分组
     */
    private String interfereGroup;

    /**
     * 病患姓名缩写
     */
    private String caseName;

    /**
     * 病患身份证
     */
    private String caseIdCard;

    /**
     * 病患取号时间
     */
    private Date updateDate;

}
