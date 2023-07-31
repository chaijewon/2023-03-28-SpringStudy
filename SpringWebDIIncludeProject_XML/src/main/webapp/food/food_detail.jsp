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
    <table class="table">
      <tr>
        <c:forTokens items="${vo.poster }" delims="^" var="img">
         <td>
           <img src="${img }" style="width: 100%">
         </td>
        </c:forTokens>
      </tr>
    </table> 
  </div>
  <div style="height: 20px"></div>
  <div class="row">
    <div class="col-sm-8">
      <table class="table">
        <tr>
         <td colspan="2"><h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3></td>
        </tr>
        <tr>
          <td width=20%>전화</td>
          <td width=80%>${vo.phone }</td>
        </tr>
        <tr>
          <td width=20%>음식종류</td>
          <td width=80%>${vo.type }</td>
        </tr>
        <tr>
          <td width=20%>가격대</td>
          <td width=80%>${vo.price }</td>
        </tr>
        <tr>
          <td width=20%>주차</td>
          <td width=80%>${vo.parking }</td>
        </tr>
        <tr>
          <td width=20%>영업시간</td>
          <td width=80%>${vo.time }</td>
        </tr>
        <tr>
          <td width=20%>메뉴</td>
          <td width=80%>${vo.menu }</td>
        </tr>
        <tr>
          <td colspan="2" class="text-right">
            <a href="../food/food_list.do?cno=${vo.cno }" class="btn btn-xs btn-success">목록</a>
          </td>
        </tr>
      </table>
    </div>
    <div class="col-sm-4">
    
    </div>
  </div>
</body>
</html>