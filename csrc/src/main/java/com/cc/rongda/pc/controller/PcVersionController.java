package com.cc.rongda.pc.controller;

import com.cc.rongda.pc.entity.PcVersion;
import com.cc.rongda.pc.service.PcVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chencheng
 * @ClassName: PcVersionController
 * @Description: 系统版本管理控制层
 * @date 2020年11月27日
 */
@RestController
@RequestMapping(value = "/pc")
public class PcVersionController {


    @Autowired
    private PcVersionService pcVersionService;

    /**
     * @param
     * @Description 根据系统版本id排序查询最新版本信息
     * @author chencheng
     * @date 2020年11月27日
     */
    @GetMapping(value = "/selectPcVersion", produces = "application/json; charset=UTF-8")
    public PcVersion selectPcVersionById() {
        return pcVersionService.selectPcVersion();
    }

}

