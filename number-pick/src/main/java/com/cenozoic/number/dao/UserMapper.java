package com.cenozoic.number.dao;

import com.cenozoic.number.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {


}
