package com.cc.rongda.pc.dao;

import com.cc.rongda.pc.entity.PcVersion;
import com.cc.rongda.pc.mapper.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PcVersionDao extends BaseDao<PcVersion> {
    PcVersion selectPcVersionBySort();
}
