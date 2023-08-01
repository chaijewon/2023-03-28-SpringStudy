<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
   <h3 class="text-center">검색 결과</h3>
   <c:if test="${count==0 }">
     <table class="table">
      <tr>
        <td class="text-center">
         <h3>검색된 결과가 없습니다</h3>
        </td>
      </tr>
     </table>
   </c:if>
   <c:if test="${count!=0 }">
     <table class="table">
       <tr>
        <td class="text-right">
         검색결과:${count }건
        </td>
       </tr>
     </table>
     <table class="table">
      <tr>
        <th width=10% class="text-center">번호</th>
        <th width=45% class="text-center">제목</th>
        <th width=15% class="text-center">이름</th>
        <th width=20% class="text-center">작성일</th>
        <th width=10% class="text-center">조회수</th>
      </tr>
      <c:forEach var="vo" items="${list }">
       <tr>
        <td width=10% class="text-center">${vo.no }</td>
        <td width=45%><a href="../databoard/detail.do?no=${vo.no }">${vo.subject }</a></td>
        <td width=15% class="text-center">${vo.name }</td>
        <td width=20% class="text-center">${vo.dbday }</td>
        <td width=10% class="text-center">${vo.hit }</td>
       </tr>
      </c:forEach>
    </table>
   </c:if>
   <table class="table">
     <tr>
       <td class="text-right">
        <a href="../databoard/list.do" class="btn btn-sm btn-primary">목록</a>
       </td>
     </tr>
   </table>
  </div>
</body>
</html>