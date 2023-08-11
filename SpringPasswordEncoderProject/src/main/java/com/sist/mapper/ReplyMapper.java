package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;

import com.sist.vo.ReplyVO;
public interface ReplyMapper {
	/*<select id="replyListData" resultType="ReplyVO" parameterType="int">
    SELECT no,fno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
    FROM springTestReply
    WHERE fno=#{fno}
    ORDER BY no DESC
   </select>*/
	public List<ReplyVO> replyListData(int fno);
   /*<insert id="replyInsert" parameterType="ReplyVO">
   INSERT INTO springTestReply VALUES(
     str_no_seq.nextval,#{fno},#{id},#{name},#{msg},SYSDATE
   )
   </insert>*/
	public void replyInsert(ReplyVO vo);
	
	@Delete("DELETE FROM springTestReply WHERE no=#{no}")
	public void replyDelete(int no);
}
