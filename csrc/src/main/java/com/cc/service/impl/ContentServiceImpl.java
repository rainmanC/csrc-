package com.cc.service.impl;

import com.cc.bean.HeadContent;
import com.cc.bean.MeetContent;
import com.cc.mapper.HeadContentMapper;
import com.cc.mapper.MeetContentMapper;
import com.cc.service.ContentService;
import com.cc.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:洛无极
 * @Date:2020/11/5
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Value("${csrc.url}")
    private String url;

    @Autowired
    private HeadContentMapper headContentMapper;
    @Autowired
    private MeetContentMapper meetContentMapper;

    @Override
    public void sendRequest(){
        String html = HttpUtils.getHtml(url);
//        System.out.println(html);
        Document document = Jsoup.parse(html);//转为Document对象

        System.out.println("开始爬取......");
        //公告头部分
        Element table_index = document.getElementsByTag("table").first().getElementsByTag("table").eq(1).first();//第一个table标签下的第一个table标签
            Element td_index = table_index.getElementsByTag("td").first(); //table标签下的第一个td
                Element b_index = td_index.getElementsByTag("b").first();
                String index_number = b_index.text(); //索引号
                String index_zhi= td_index.text();  //索引号对应的值 :索 引 号:40000895X/
                 int indexBefore = index_zhi.indexOf(":");
                String index_number_zhi = index_zhi.substring(indexBefore+1);
                System.out.println( index_zhi);

            Element td_category = table_index.getElementsByTag("td").last(); //table下的最后一个td
                Element b_category= td_category.getElementsByTag("b").first(); //分类所在元素
                String category = b_category.text(); //分类
                Element span_category = td_category.getElementsByTag("span").first();//分类值对应元素
                String category_zhi = span_category.text(); // 分类对应值
                System.out.println(category+ " : "+category_zhi);

        //发布机构: 证监会
        Element table_csrc = document.getElementsByTag("table").first().getElementsByTag("table").eq(2).first();//第一个table标签下的第二个table标签
            Element td_csrc = table_csrc.getElementsByTag("td").first();
                Element b_csrc = td_csrc.getElementsByTag("b").first();
                String issuing_agency = b_csrc.text();//发布机构
                Element span_csrc = td_csrc.getElementsByTag("span").first();
                String issuing_agency_zhi = span_csrc.text();//证监会
                System.out.println(issuing_agency +" : "+issuing_agency_zhi);

        //发文日期: 2017年12月29日
        Element td_publish_date = table_csrc.getElementsByTag("td").last();
            Element b_publish = td_publish_date.getElementsByTag("b").first();
                String publish_date = b_publish.text();//发文日期
            Element span_publish = td_publish_date.getElementsByTag("span").first();
                String publish_date_zhi = span_publish.text();//时间
                System.out.println(publish_date+" : "+publish_date_zhi);

        //名称 : 第十七届发审委2018年第5次工作会议公告
        Element b_name = document.getElementById("lTitle").previousElementSibling();//名称
            String name = b_name.text();
            Element span_name = document.getElementById("lTitle");//名称对应的值
                String name_zhi = span_name.text();
                System.out.println(name+" : "+name_zhi);

        //文号 : 无   主题词 :
        Element lastLine = document.getElementsByTag("table").first().getElementsByTag("tr").last();
            Element td_textNumber = lastLine.getElementsByTag("td").first();
                Element b_textNumber =td_textNumber.getElementsByTag("b").first();//文号
                    String text_number = b_textNumber.text();
                Element span_textNumber = td_textNumber.getElementsByTag("span").first();
                    String text_number_zhi = span_textNumber.text();
                    System.out.println(text_number+" : "+text_number_zhi);


            Element td_first_words = lastLine.getElementsByTag("td").last();
                Element b_first_words =td_first_words.getElementsByTag("b").first();//主题词
                    String first_words = b_first_words.text();
                Element span_first_words = td_first_words.getElementsByTag("span").first();
                    String first_keywords_zhi = span_first_words.text();
                    System.out.println(first_words+" : " +first_keywords_zhi);

        //标题
        Element titleElement = document.select("p[align=center]").get(0);//选择第一个指定文档内容为‘p[align=center]’的内容
            String strTitle = titleElement.toString();
                String regex = "var strssre=(.*);"; //正则匹配规则
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(strTitle);
                String title = "";
                if (matcher.find()){
                    title = matcher.group(); //获取符合匹配规则的字符串
                }
            int indexFirst = title.indexOf("\"");//字符串截取，拿到目标文本
            int indexLast = title.lastIndexOf("\"");
                String meet_title = title.substring(indexFirst+1,indexLast);
                System.out.println(meet_title);

        //发审委部分
        Element ps = document.getElementsByClass("Custom_UnionStyle").first();
            Element p1 = ps.getElementsByTag("p").get(1); //一、参会发审委委员
            String weiyuan1 = p1.text();
            System.out.println(weiyuan1);
            Element p2 = ps.getElementsByTag("p").get(2); //委员第一组
            String weiyuan1_person1 = p2.text();//
            System.out.println(weiyuan1_person1);
            Element p3 = ps.getElementsByTag("p").get(3); //委员第二组
            String weiyuan1_person2 = p3.text();//
            System.out.println(weiyuan1_person2);
            Element p4 = ps.getElementsByTag("p").get(4); //审核的发行人
            String publisher1 = p4.text();
            System.out.println(publisher1);
            Element p5 = ps.getElementsByTag("p").get(5); //发行人公司
            String publisher1_company = p5.text();
            System.out.println(publisher1_company);
            Element p6 = ps.getElementsByTag("p").get(6); //二、参会发审委委员
            String weiyuan2 = p6.text();
            System.out.println(weiyuan2);
            Element p7 = ps.getElementsByTag("p").get(7); //委员第一组
            String weiyuan2_person1 = p7.text();
            System.out.println(weiyuan2_person1);
            Element p8 = ps.getElementsByTag("p").get(8); //委员第二组
            String weiyuan2_person2 = p8.text();
            System.out.println(weiyuan2_person2);
            Element p9 = ps.getElementsByTag("p").get(9); //审核的发行人
            String publisher2 = p9.text();
            System.out.println(publisher2);
            Element p10 = ps.getElementsByTag("p").get(10); //发行人公司
            String publisher2_company = p10.text();
            System.out.println(publisher2_company);
            Element p11 = ps.getElementsByTag("p").get(11); //三、参会发审委委员
            String weiyuan3 = p11.text();
            System.out.println(weiyuan3);
            Element p12 = ps.getElementsByTag("p").get(12); //委员第一组
            String weiyuan3_person1 = p12.text();
            System.out.println(weiyuan3_person1);
            Element p13 = ps.getElementsByTag("p").get(13); //委员第二组
            String weiyuan3_person2 = p13.text();
            System.out.println(weiyuan3_person2);
            Element p14 = ps.getElementsByTag("p").get(14); //审核的发行人
            String publisher3 = p14.text();
            System.out.println(publisher3);
            Element p15 = ps.getElementsByTag("p").get(15); //发行人公司
            String publisher3_company = p15.text();
            System.out.println(publisher3_company);

        HeadContent headContent = new HeadContent(index_number_zhi,category_zhi,issuing_agency_zhi,publish_date_zhi,name_zhi,text_number_zhi,first_keywords_zhi);

        MeetContent meetContent1 = new MeetContent(meet_title,weiyuan1_person1+weiyuan1_person2,publisher1_company);
        MeetContent meetContent2 = new MeetContent(meet_title,weiyuan2_person1+weiyuan1_person2,publisher2_company);
        MeetContent meetContent3 = new MeetContent(meet_title,weiyuan3_person1+weiyuan1_person2,publisher3_company);
         List<MeetContent> meetContents = new ArrayList<>();
             meetContents.add(meetContent1);
             meetContents.add(meetContent2);
             meetContents.add(meetContent3);

          headContentMapper.insert(headContent); //存储进数据库
          meetContentMapper.insert(meetContents); //存储进数据库
    }
}
