package com.cenozoic.number.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
@Data
public class User {

    @Id
    private Integer userId;

    private String userName;

    private String password;
    /**
     * 中心编号
     */
    private Integer centerId;
    /**
     * 用户所属中心
     */
    private String center;

}
