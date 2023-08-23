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
<div class="wrapper row4">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="one_third first">
      <h6 class="title">맛집 베스트 Top7</h6>
      <ul class="nospace linklist">
       <c:forEach var="vo" items="${fList }">
        <li><a href="#">${vo.name }(${vo.type })</a></li>
       </c:forEach>
      </ul>
    </div>
    <div class="one_third">
      <h6 class="title">서울 여행 Top7</h6>
      <ul class="nospace linklist">
       <c:forEach var="s" items="${sList }">
        <li><a href="#">${s }</a></li>
       </c:forEach>
        
      </ul>
    </div>
    <div class="one_third">
      <h6 class="title">레시피 Top7</h6>
      <ul class="nospace linklist">
       <c:forEach var="r" items="${rList }">
         <li><a href="#">${r }</a></li>
       </c:forEach>
        
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </footer>
</div>
<div class="wrapper row5">
  <div id="copyright" class="clear"> 
    <!-- ################################################################################################ -->
    <p class="fl_left">Copyright &copy; 2023 - <a href="#">강북쌍용교육센터</a></p>
    <p class="fl_right">by <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">홍길동</a></p>
    <!-- ################################################################################################ --> 
  </div>
</div>
</body>
</html>