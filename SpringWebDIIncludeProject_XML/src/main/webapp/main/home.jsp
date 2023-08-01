<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#images {
  width: 400px;
  height: 250px;
  overflow: hidden;
  position: relative;
  
  margin: 20px auto;
}
#images img {
  width: 400px;
  height: 250px;
  
  position: absolute;
  top: 0;
  left: -400px;
  z-index: 1;
  opacity: 0;
  
  transition: all linear 500ms;
  -o-transition: all linear 500ms;
  -moz-transition: all linear 500ms;
  -webkit-transition: all linear 500ms;
}
#images img:target {
  left: 0;
  z-index: 9;
  opacity: 1;
}
#images img:first-child {
  left: 0;
  opacity: 1;
}
#slider a {
  text-decoration: none;
  background: #E3F1FA;
  border: 1px solid #C6E4F2;
  padding: 4px 6px;
  color: #222;
}
#slider a:hover {
  background: #C6E4F2;
}
</style>
</head>
<body>
  <div class="row">
    <div class="text-center">
      <a href="../main/main.do" class="btn btn-sm btn-danger">믿고 보는 맛집 리스트</a>
      <a href="../main/main.do?cno=2" class="btn btn-sm btn-success">지역별 인기 맛집 리스트</a>
      <a href="../main/main.do?cno=3" class="btn btn-sm btn-warning">메뉴별 인기 맛집 리스트</a>
    </div>
  </div>
  <div style="height: 20px"></div>
  <div class="row">
   <c:forEach var="vo" items="${list }" varStatus="s">
        <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../food/food_list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p style="font-size: 9px">${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
      </c:forEach>
  </div>
  <div style="height: 10px"></div>
  <h3>최신 방문 맛집</h3>
  <hr>
  <div class="row">
    <div id="images">
     <c:forEach var="cvo" items="${cList }">
       <img id="image${cvo.fno }" src="${cvo.poster }" class="img-rounded"/>
     </c:forEach>
     </div>
     <div id="slider" class="text-center">
      <c:forEach var="cvo" items="${cList }" varStatus="s">
        <c:if test="${s.index<10 }">
         <a href="#image${cvo.fno }">${s.index+1 }</a>
        </c:if>
      </c:forEach>
     </div>
  </div>
</body>
</html>