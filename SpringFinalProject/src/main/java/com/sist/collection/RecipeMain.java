package com.sist.collection;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sist.dao.*;
public class RecipeMain {
    
	
	public RecipeDetailVO recipeDetailData(String url,int no)
    {
    	RecipeDetailVO vo=new RecipeDetailVO();
    	// http://www.10000recipe.com/recipe/6907454
    	/*
    	 *  https://www.10000recipe.com/recipe/6998538
    	 *  div.ready_ingre3 li
    	 */
    	int k=1;
    	try
    	{
    		Document doc=Jsoup.connect("http://www.10000recipe.com"+url).get();
    		Element poster=doc.selectFirst("div.centeredcrop img");// doc.select("").get(0)
    		
    		Element title=doc.selectFirst("div.view2_summary h3");
    		Element chef=doc.selectFirst("div.profile_cont p.cont_name");
    		Element chef_poster=doc.selectFirst("div.profile_pic img");
    		Element chef_profile=doc.selectFirst("div.profile_cont p.cont_intro");
    		Element content=doc.selectFirst("div.view2_summary_in");
    		Elements foodmake=doc.select("div.view_step_cont");
    		Elements foodimg=doc.select("div[id*=stepimg] img[src*=/recipe/]");
    		Element info1=doc.selectFirst("span.view2_summary_info1");
    		Element info2=doc.selectFirst("span.view2_summary_info2");
    		Element info3=doc.selectFirst("span.view2_summary_info3");
    		Elements data=doc.select("div.ready_ingre3 li");
    		/*
    		 *  <img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/28/fdbb88682cc022c7b4a8347038d7b8b81.jpg">
    		 */
    		String food="";
    		for(int i=0;i<foodmake.size();i++)
    		{
    			food+=(i+1)+"."+foodmake.get(i).text()+"^"+foodimg.get(i).attr("src")+"\n";
    		}
    		//System.out.println(food);
    		vo.setPoster(poster.attr("src"));
    		vo.setChef(chef.text());
    		vo.setChef_poster(chef_poster.attr("src"));
    		vo.setChef_profile(chef_profile.text());
    		vo.setContent(content.text());
    		vo.setFoodmake(food);
    		vo.setTitle(title.text());
    		vo.setInfo1(info1.text());
    		vo.setInfo2(info2.text());
    		vo.setInfo3(info3.text());
    		vo.setNo(no);
    		
    		String ss="";
    		for(int i=0;i<data.size();i++)
    		{
    			ss+=data.get(i).text()+",";
    		}
    		ss=ss.substring(0,ss.lastIndexOf(","));
    		vo.setData(ss);
    		//d=d.replace("구매", "");
    		//d=d.replace(" ", ",");
    		System.out.println("번호:"+no);
    		System.out.println("재료:"+ss.replace("구매", ""));
    		System.out.println("제목:"+vo.getTitle());
    		System.out.println("쉐프:"+vo.getChef());
    		System.out.println("내용:"+vo.getContent());
    		System.out.println("조리법:"+vo.getFoodmake());
    		System.out.println("정보1:"+vo.getInfo1());
    		System.out.println("정보2:"+vo.getInfo2());
    		System.out.println("정보3:"+vo.getInfo3());
    		Thread.sleep(100);
    		System.out.println("k="+k);
    		k++;
    	}catch(Exception ex){}
    	return vo;
    }
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RecipeMain rm=new RecipeMain();
		DataDAO dao=new DataDAO();
		List<RecipeVO> list=dao.recipeData();
		for(RecipeVO vo:list)
		{
			RecipeDetailVO rvo=rm.recipeDetailData(vo.getLink(), vo.getNo());
			dao.recipeDetailInsert(rvo);
		}
		
	}
	

}
