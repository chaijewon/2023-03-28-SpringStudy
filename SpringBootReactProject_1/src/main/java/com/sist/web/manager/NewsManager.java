package com.sist.web.manager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.sist.web.entity.NewsVO;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
/*
 *   "items":[		
 *     {"title":"'출산 5개월' 허이제이 &quot;층간소음 걱정 없는 1층으로 이사 고려 중&quot; (구해줘홈...",			
 *     "originallink":"http:\/\/www.tvdaily.co.kr\/read.php3?aid=16938826791685075019",			
 *     "link":"http:\/\/www.tvdaily.co.kr\/read.php3?aid=16938826791685075019",			
 *     "description":"두 사람이 찾은 곳은 부산 강서구 명지 국제 신도시에 위치한 대단지 아파트로 단지 내 <b>맛집<\/b>과 학원, 병원 등 다양한 편의시설을 갖추고 있다고 한다. 의뢰인 남편의 직장까지 대중교통으로 40분이 소요됐으며 어린이집과... ",			
 *     "pubDate":"Tue, 05 Sep 2023 12:12:00 +0900"		}
 */
@Component
public class NewsManager {
   public static void main(String[] args) {
	   //NewsManager m=new NewsManager();
	   //m.newsFind("맛집");
   }
   public List<NewsVO> newsFind(String fd)
   {
	   List<NewsVO> list=
			   new ArrayList<NewsVO>();
	   String clientId = "xzCkjdHVMmHBQA5GsaNk"; //애플리케이션 클라이언트 아이디
       String clientSecret = "xpoZsdLvAt"; //애플리케이션 클라이언트 시크릿


       String text = null;
       try {
           text = URLEncoder.encode(fd, "UTF-8");
       } catch (UnsupportedEncodingException e) {
           throw new RuntimeException("검색어 인코딩 실패",e);
       }


       String apiURL = "https://openapi.naver.com/v1/search/news.json?display=100&query=" + text;    // JSON 결과
       //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


       Map<String, String> requestHeaders = new HashMap<>();
       requestHeaders.put("X-Naver-Client-Id", clientId);
       requestHeaders.put("X-Naver-Client-Secret", clientSecret);
       String responseBody = get(apiURL,requestHeaders);


       System.out.println(responseBody);
       
       try
       {
    	   JSONParser jp=new JSONParser();
    	   JSONObject root=(JSONObject)jp.parse(responseBody);
    	   JSONArray arr=(JSONArray)root.get("items");
    	   // {} => JSONObject  [] => JSONArray
    	   for(int i=0;i<arr.size();i++)
    	   {
    		   JSONObject obj=(JSONObject)arr.get(i);
    		   //{}
    		   NewsVO vo=new NewsVO();
    		   vo.setTitle((String)obj.get("title"));
    		   vo.setDesc((String)obj.get("description"));
    		   vo.setLink((String)obj.get("link"));
    		   vo.setPubdata(new SimpleDateFormat("yyyy-MM-dd").format(
    				   new Date((String)obj.get("pubDate"))));
    		   list.add(vo);
    	   }
       }catch(Exception ex){}
       
	   return list;
   }
   private static String get(String apiUrl, Map<String, String> requestHeaders){
       HttpURLConnection con = connect(apiUrl);
       try {
           con.setRequestMethod("GET");
           for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
               con.setRequestProperty(header.getKey(), header.getValue());
           }


           int responseCode = con.getResponseCode();
           if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
               return readBody(con.getInputStream());
           } else { // 오류 발생
               return readBody(con.getErrorStream());
           }
       } catch (IOException e) {
           throw new RuntimeException("API 요청과 응답 실패", e);
       } finally {
           con.disconnect();
       }
   }


   private static HttpURLConnection connect(String apiUrl){
       try {
           URL url = new URL(apiUrl);
           return (HttpURLConnection)url.openConnection();
       } catch (MalformedURLException e) {
           throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
       } catch (IOException e) {
           throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
       }
   }


   private static String readBody(InputStream body){
       InputStreamReader streamReader = new InputStreamReader(body);


       try (BufferedReader lineReader = new BufferedReader(streamReader)) {
           StringBuilder responseBody = new StringBuilder();


           String line;
           while ((line = lineReader.readLine()) != null) {
               responseBody.append(line);
           }


           return responseBody.toString();
       } catch (IOException e) {
           throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
       }
   }
}
