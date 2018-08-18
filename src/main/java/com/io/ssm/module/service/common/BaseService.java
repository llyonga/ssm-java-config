package com.io.ssm.module.service.common;


import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @description: 业务处理基类
 * @author: llyong
 * @date: 2018/8/9
 * @time: 14:42
 * @version: 1.0
 */
public interface BaseService<T> {
    long countByExample(T t);

    int deleteByExample(T t);

    int deleteByPrimaryKey(Long userId);

    int insert(T t);

    int insertSelective(T t);

    PageListDto<T> selectByExampleWithRowbounds(T t, RowBounds rowBounds,String orderBy);

    PageListDto<T> selectByExampleWithRowbounds(T t, RowBounds rowBounds);

    List<T> selectByExample(T t);

    T selectByPrimaryKey(Long var);

    int updateByExampleSelective(T t);

    int updateByExample(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
