package com.cc.rongda.pc.service.impl;

import com.cc.rongda.pc.dao.PcVersionDao;
import com.cc.rongda.pc.entity.PcVersion;
import com.cc.rongda.pc.service.PcVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chencheng
 * @ClassName: PcVersionServiceImpl
 * @create 2020年11月27日
 * @Description: 系统版本号管理接口实现
 */

@Service
public class PcVersionServiceImpl implements PcVersionService {

    @Autowired
    private PcVersionDao pcVersionDao;

    /**
     * @param
     * @Description 根据系统版本id排序查询最新版本信息
     * @author chencheng
     * @date 2020年11月27日
     */
    @Override
    public PcVersion selectPcVersion() {
//        Example example = new Example(PcVersion.class);
//        example.setOrderByClause("id desc");
//        Example.Criteria criteria = example.createCriteria();

      PcVersion pcVersion = pcVersionDao.selectPcVersionBySort();
        return pcVersion;
    }


}
