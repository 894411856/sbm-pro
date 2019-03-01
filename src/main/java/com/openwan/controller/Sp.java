package com.openwan.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sp {

    //大乐透
    private static String DA_LE_TOU = "http://kaijiang.500.com/shtml/dlt/18016.shtml?0_ala_baidu";
    //双色球
    private static String SHUANG_SE_QIU = "http://kaijiang.500.com/ssq.shtml";
    //3D
    private static String _3D = "http://kaijiang.500.com/sd.shtml";

    //超级大乐透
    private static String CHAO_JI_DA_LE_TOU = "http://kaijiang.500.com/dlt.shtml";

    //七星彩
    private static String QI_XING_CAI = "http://kaijiang.500.com/qxc.shtml";

    //排列五
    private static String PAI_LIE_WU = "http://kaijiang.500.com/plw.shtml";

    //排列3
    private static String PAI_LIE_SAN = "http://kaijiang.500.com/pls.shtml";

    //22选5
    private static String _22_XUAN_5 = "http://kaijiang.500.com/eexw.shtml";




	public static void main(String[] args) {

      /*  System.out.println("抓取信息：");
        Get_Url(DA_LE_TOU);
		Get_Url(SHUANG_SE_QIU);
		Get_Url(_3D);
		Get_Url(CHAO_JI_DA_LE_TOU);
		Get_Url(QI_XING_CAI);
		Get_Url(PAI_LIE_WU);
		Get_Url(PAI_LIE_SAN);*/
		//Get_Url(_22_XUAN_5);
        vpi2("https://v.qq.com/x/cover/1efvvnobsa3zbcc.html");
        //vpi2("https://v.qq.com/x/cover/7kv5tlxaobmqpvb.html");
	}
	public void  start(){
        System.out.println("抓取信息：");
       /* Get_Url(DA_LE_TOU);
        Get_Url(SHUANG_SE_QIU);
        Get_Url(_3D);
        Get_Url(CHAO_JI_DA_LE_TOU);
        Get_Url(QI_XING_CAI);
        Get_Url(PAI_LIE_WU);
        Get_Url(PAI_LIE_SAN);*/
        vpi2("https://v.qq.com/x/cover/1efvvnobsa3zbcc.html");

    }
	
	
	public static void Get_Url(String url) {
        try {
         Document doc = Jsoup.connect(url).timeout(3000)
          //.data("query", "Java")
          //.userAgent("头部")
          //.cookie("auth", "token")
          //.timeout(3000)
          //.post()
          .get();
         //System.out.println("doc:"+doc);

        //得到html的所有东西

        Elements tilte = doc.getElementsByClass("td_title01");

        System.out.println(tilte.get(0).text());
        System.out.println("----------------------------");


        Elements content2 = doc.getElementsByClass("ball_box01");

        System.out.println("中奖号码 ："+content2.get(0).text());

        System.out.println();
        System.out.println();
        System.out.println();

        //分离出html下<a>...</a>之间的所有东西
       /* Elements links = content2.get(0).getElementsByTag("li");
        //System.out.println(links);
        for(Element e : links){
            System.out.println(e.text());
        }
           */


     /**Elements links = content.getElementsByTag("a");
        //Elements links = doc.select("a[href]");
        // 扩展名为.png的图片
        Elements pngs = doc.select("img[src$=.png]");
        // class等于masthead的div标签
        Element masthead = doc.select("div.masthead").first();

        for (Element link : links) {
              //得到<a>...</a>里面的网址
              String linkHref = link.attr("href");
              //得到<a>...</a>里面的汉字
              String linkText = link.text();
              System.out.println(linkText);
         }*/
        } catch (IOException e) {
              e.printStackTrace();
        }
    }




    public static List<String> resultCai(String url) {
        try {
            Document doc = Jsoup.connect(url).timeout(3000)
                    //.data("query", "Java")
                    //.userAgent("头部")
                    //.cookie("auth", "token")
                    //.timeout(3000)
                    //.post()
                    .get();
            //System.out.println("doc:"+doc);

            //得到html的所有东西
            Elements nav_pop_content = doc.getElementsByClass("nav_pop_content");
          //  System.out.println(nav_pop_content);

            Elements slider_nav = doc.getElementsByClass("slider_nav");
            System.out.println(slider_nav.get(0) );
            System.out.println(slider_nav.get(0).text());


        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        return list ;
    }



    public static void vpi2(String url) {
        try {
            Document doc = Jsoup.connect(url).timeout(3000)
                    //.data("query", "Java")
                    //.userAgent("头部")
                    //.cookie("auth", "token")
                    //.timeout(3000)
                    //.post()
                    .get();
            // System.out.println("doc:"+doc);

            //得到html的所有东西
            Elements mod_episode = doc.getElementsByClass("mod_episode");
            System.out.println(mod_episode.get(0).getElementsByTag("a"));
            System.out.println("------------------------------------------------");



            //https://v.qq.com
            Elements slider_nav = doc.getElementsByClass("slider_nav");
            System.out.println(slider_nav.get(0) );
            System.out.println(slider_nav.get(0).text());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
