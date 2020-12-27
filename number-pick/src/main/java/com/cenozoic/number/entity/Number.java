package com.cenozoic.number.entity;

import com.cenozoic.number.annotation.ExcelColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @ExcelColumn(value = "中心", col = 1)
    private String center;

    /**
     * 布氏分期 1 痉挛期，2 恢复期
     */
    private Integer brinellId;

    @ExcelColumn(value = "布氏分期", col = 2)
    private String brinellPeriods;

    /**
     * 病例序号
     */
    @ExcelColumn(value = "病例序号", col = 3)
    private String caseNum;

    /**
     * 病例随机编号
     */
    @ExcelColumn(value = "病例随机编号", col = 4)
    private Integer randomNum;

    /**
     * 干预方法分组
     */
    @ExcelColumn(value = "干预方法分组", col = 5)
    private String interfereGroup;

    /**
     * 病患姓名缩写
     */
    @ExcelColumn(value = "姓名缩写", col = 6)
    private String caseName;

    /**
     * 病患身份证
     */
    @ExcelColumn(value = "身份证号", col = 7)
    private String caseIdCard;

    /**
     * 病患取号时间
     */
    @ExcelColumn(value = "取号时间", col = 8)
    private Date updateDate;

}
