package com.cc.mapper;


import com.cc.bean.MeetContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetContentMapper {
    void insert(List<MeetContent> meetContents);
}
