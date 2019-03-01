package com.openwan.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lujun.chen on 2017/3/13.
 */
@Controller
public class CityController {

 

	
	@ResponseBody
	@RequestMapping("/")
	public String resultDataInfo(HttpServletRequest request , HttpServletResponse response) throws IOException{
		return "hello";
	}
	@ResponseBody
	@RequestMapping("/index")
	public String index(ModelMap map){
		//map.put("title", "HelloWorld");
		System.out.println("aa");
		return "index";
	}










	@ResponseBody
	@RequestMapping("/springBoot")
	public String index() {
		String [] urls = {
				"http://kaijiang.500.com/sd.shtml",
				"http://kaijiang.500.com/shtml/dlt/18016.shtml?0_ala_baidu",
				"http://kaijiang.500.com/ssq.shtml",
				"http://kaijiang.500.com/dlt.shtml",
				"http://kaijiang.500.com/qxc.shtml",
				"http://kaijiang.500.com/plw.shtml",
				"http://kaijiang.500.com/pls.shtml",
				"http://kaijiang.500.com/eexw.shtml"

		} ;


		return result(urls);
	}













	public String result(String [] urls)  {

		if(urls.length <0){
			return null ;
		}
		StringBuffer sb = new StringBuffer();
		Document doc = null;
		for(String url :urls ){

			try {
				doc = Jsoup.connect(url).timeout(3000)
						//.data("query", "Java")
						//.userAgent("头部")
						//.cookie("auth", "token")
						//.timeout(3000)
						//.post()
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}


			//得到html的所有东西
			Elements tilte = doc.getElementsByClass("td_title01");
			System.out.println(tilte.get(0).text());
			sb.append("<br/>");
			sb.append(tilte.get(0).text());
			sb.append("<br/>");
			sb.append("----------------------------");
			sb.append("<br/>");
			System.out.println("----------------------------");
			Elements content2 = doc.getElementsByClass("ball_box01");
			System.out.println("中奖号码 ："+content2.get(0).text());
			sb.append("中奖号码 ："+content2.get(0).text());
			sb.append("<br/>");


		}





		return sb.toString() ;
	}

}
