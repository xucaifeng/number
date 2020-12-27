package com.cenozoic.number.service;

import com.cenozoic.number.dto.Resp;
import com.cenozoic.number.entity.Number;

import java.util.List;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-21
 **/
public interface INumberService {

    /**
     * 获取各中心各布氏分期未分配号码
     * @param centerId
     * @return
     */
    Resp getRemainNumByCenterId(Integer centerId);

    /**
     * 选号
     * @param centerId
     * @param brinellId
     * @param caseName
     * @param caseIdCard
     * @return
     */
    Resp pickNumber(String centerId, String brinellId, String caseName, String caseIdCard);

    /**
     * 查询所有
     * @return
     */
    List<Number> selectAll();


}
