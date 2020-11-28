package com.cc.rongda.pc.service;


import com.cc.rongda.pc.entity.PcVersion;

/**
 * @author chencheng
 * @ClassName: PcVersionService
 * @create 2020年11月27日
 * @Description: 系统版本号管理接口
 */
public interface PcVersionService {

    /**
     * @param
     * @Description 根据系统版本id排序查询最新版本信息
     * @author chencheng
     * @date 2020年11月27日
     */

    PcVersion selectPcVersion();

}
