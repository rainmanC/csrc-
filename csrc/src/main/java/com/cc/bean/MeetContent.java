package com.cc.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:洛无极
 * @Date:2020/11/5
 */
public class MeetContent {
    private String meet_title;//公告标题
    private String weiyuan ;//参会发审委委员
    private String publisher ;// 审核的发行人


    public MeetContent() {
    }

    public MeetContent(String meet_title, String weiyuan, String publisher) {
        this.meet_title = meet_title;
        this.weiyuan = weiyuan;
        this.publisher = publisher;
    }

    public String getMeet_title() {
        return meet_title;
    }

    public void setMeet_title(String meet_title) {
        this.meet_title = meet_title;
    }

    public String getWeiyuan() {
        return weiyuan;
    }

    public void setWeiyuan(String weiyuan) {
        this.weiyuan = weiyuan;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "MeetContent{" +
                "meet_title='" + meet_title + '\'' +
                ", weiyuan=" + weiyuan +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
