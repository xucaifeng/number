package com.cenozoic.number.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cenozoic.number.constant.Constant;
import com.cenozoic.number.dao.NumberMapper;
import com.cenozoic.number.dto.Resp;
import com.cenozoic.number.entity.Number;
import com.cenozoic.number.service.INumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-21
 **/
@Service
@Slf4j
public class NumberServiceImpl implements INumberService {

    @Autowired
    NumberMapper numberMapper;

    @Override
    public Resp getRemainNumByCenterId(Integer centerId) {

        Map map = new HashMap<>();

        Example example = new Example(Number.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("centerId", centerId);
        criteria.andIsNull("caseIdCard");
        List<Number> numberList = numberMapper.selectByExample(example);

        // 根据布氏分期分组
        Map<Integer, List<Number>> numberListMap = numberList.stream().collect(Collectors.groupingBy(Number::getBrinellId));

        for (Integer brinellId : numberListMap.keySet()) {
            map.put(brinellId, numberListMap.get(brinellId).size());
        }
        log.info("getRemainNumByCenterId_centerId={}, response={}", centerId, Resp.success(map));
        return Resp.success(map);
    }


    @Override
    public Resp pickNumber(String centerId, String brinellId, String caseName, String caseIdCard) {

        Number caseNumber = new Number();
        caseNumber.setCaseIdCard(caseIdCard);
        List<Number> numbers = numberMapper.select(caseNumber);
        if (numbers != null && numbers.size() > 0) {
            return Resp.fail(Constant.RespStatus.FAIL.getCode(), "该患者已经参与【"+numbers.get(0).getCenter()+"】的试验分组，请核查！", numbers.get(0));
        }

        Example example = new Example(Number.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("centerId", centerId);
        criteria.andEqualTo("brinellId", brinellId);
        criteria.andIsNull("caseIdCard");
        example.orderBy("caseNum").asc();
        numbers = numberMapper.selectByExample(example);
        for (Number number : numbers) {
            number.setCaseName(caseName);
            number.setCaseIdCard(caseIdCard);
            number.setUpdateDate(new Date());
            criteria = example.createCriteria();
            criteria.andEqualTo("id", number.getId());
            criteria.andIsNull("caseIdCard");
            example.and(criteria);

            int num = numberMapper.updateByExample(number, example);
            if (num > 0) {
                return Resp.success(number);
            }
        }

        return Resp.fail("未取到号");
    }


    @Override
    public List<Number> selectAll() {
        return numberMapper.selectAll();
    }


    public List<Map<String, Object>> selectList() {
        List<Number> numberList = numberMapper.selectAll();
        List<Map<String, Object>> data = numberList.stream().map(this::numberToMap).collect(Collectors.toList());
        return data;
    }
    private Map<String, Object> numberToMap(Number number) {
        return JSONObject.parseObject(JSON.toJSONString(number), Map.class);
    }


}
