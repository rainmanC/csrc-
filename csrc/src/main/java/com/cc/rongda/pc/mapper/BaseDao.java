package com.cc.rongda.pc.mapper;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author chencheng
 * @ClassName: BaseDao
 * @Description: 通用mapper, 可完成对单表的简单增删改查
 * @date 2020年11月27日
 */
public interface BaseDao<T> extends Mapper<T> {

}
