package com.cenozoic.number.dao;

import com.cenozoic.number.entity.Number;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-21
 **/
@Component
@Mapper
public interface NumberMapper extends BaseMapper<Number> {
}
