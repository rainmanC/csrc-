package com.cc.bean;


public class HeadContent {

    private String index_number;//索引号
    private String category; //分类
    private String issuing_agency; //发布机构
    private String publish_date; //发布时间
    private String h_name; //名称
    private String text_number;//文号
    private String first_words; //主题词


    public HeadContent() {
    }

    public HeadContent(String index_number, String category, String issuing_agency, String publish_date, String h_name, String text_number, String first_words) {
        this.index_number = index_number;
        this.category = category;
        this.issuing_agency = issuing_agency;
        this.publish_date = publish_date;
        this.h_name = h_name;
        this.text_number = text_number;
        this.first_words = first_words;
    }

    public String getIndex_number() {
        return index_number;
    }

    public void setIndex_number(String index_number) {
        this.index_number = index_number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIssuing_agency() {
        return issuing_agency;
    }

    public void setIssuing_agency(String issuing_agency) {
        this.issuing_agency = issuing_agency;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getText_number() {
        return text_number;
    }

    public void setText_number(String text_number) {
        this.text_number = text_number;
    }

    public String getFirst_words() {
        return first_words;
    }

    public void setFirst_words(String first_words) {
        this.first_words = first_words;
    }

    @Override
    public String toString() {
        return "HeadContent{" +
                "index_number='" + index_number + '\'' +
                ", category='" + category + '\'' +
                ", issuing_agency='" + issuing_agency + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", name='" + h_name + '\'' +
                ", text_number='" + text_number + '\'' +
                ", first_words='" + first_words + '\'' +
                '}';
    }
}