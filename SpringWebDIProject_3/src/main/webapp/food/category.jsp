<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <a href="category.do?cno=1" class="btn btn-sm btn-danger">믿고보는 맛집 리스트</a>
      <a href="category.do?cno=2" class="btn btn-sm btn-info">지역별 맛집 리스트</a>
      <a href="category.do?cno=3" class="btn btn-sm btn-success">인기 메뉴별 맛집 리스트</a>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
         <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p style="font-size: 9px">${vo.title }</p>
		        </div>
		      </a>
		      
		    </div>
		  </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>