package com.sist.manager;

import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;

public class KeywordManager {
   public static void main(String[] args) {
	    String keyword="매콤 달달하고 맛에 깊이감이 있는 무채육수 쌀떡볶이 맛집. 고춧가루의 깔끔한 매운 맛과 물엿 단 맛의 조합이 좋고, 떡볶이 국물은 마셔도 될만큼 자극적이지 않고 맛이 좋음. 어묵은 식감 살아있는 편. 가래떡은 쫀득한 식감이 있지만 과하지 않고 적당히 부드럽게 뭉개지는 식감에 국물이 겉도는 느낌이 들지않아 밀떡파에게도 환영받을 만한 맛이다.";
	    KeywordExtractor ke=new KeywordExtractor();
	    KeywordList list=ke.extractKeyword(keyword, true);
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	Keyword wrd=list.get(i);
	    	System.out.println(wrd.getString()+":"+wrd.getCnt());
	    }
   }
}
