package com.cc.mapper;


import com.cc.bean.HeadContent;
import com.cc.bean.MeetContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadContentMapper {

    void insert(HeadContent headContent);
}
