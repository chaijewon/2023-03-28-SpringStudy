<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1 {
   width: 700px;
}
</style>
</head>
<body>
   <div class="row row1">
     <h3 class="text-center">내용 보기</h3>
     <table class="table">
      <tr>
       <th class="danger text-center" width=20%>번호</th>
       <td class="text-center" width=30%>${vo.no }</td>
       <th class="danger text-center" width=20%>작성일</th>
       <td class="text-center" width=30%>${vo.dbday }</td>
      </tr>
      <tr>
       <th class="danger text-center" width=20%>이름</th>
       <td class="text-center" width=30%>${vo.name }</td>
       <th class="danger text-center" width=20%>조회수</th>
       <td class="text-center" width=30%>${vo.hit }</td>
      </tr>
      <tr>
       <th class="danger text-center" width=20%>제목</th>
       <td colspan="3">${vo.subject }</td>
      </tr>
      <c:if test="${vo.filecount!=0 }">
	      <tr>
	       <th class="danger text-center" width=20%>첨부파일</th>
	       <td colspan="3">
	        <ul>
	         <c:forEach var="fn" items="${nList }" varStatus="s">
	           <li><a href="../databoard/download.do?fn=${fn }">${fn }</a>(${sList[s.index] }Bytes)</li>
	         </c:forEach>
	        </ul>
	       </td>
	      </tr>
      </c:if>
      <tr>
        <td colspan="4" class="text-left" valign="top" height="200">
         <pre style="white-space: pre-wrap;background-color: white;border:none">${vo.content }</pre>
        </td>
      </tr>
      <tr>
        <td colspan="4" class="text-right">
         <a href="../databoard/update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
         <a href="../databoard/delete.do?no=${vo.no }" class="btn btn-xs btn-success">삭제</a>
         <a href="../databoard/list.do" class="btn btn-xs btn-info">목록</a>
        </td>
      </tr>
     </table>
   </div>
</body>
</html>






