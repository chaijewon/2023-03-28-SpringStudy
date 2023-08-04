<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">
           <form method="" action="" class="inline">
            <input type=text name=fd size=20 class="input-sm" required value="${fd }">
            <input type=submit value="검색" class="btn btn-sm btn-priamry">
           </form>
          </header>
          <ul class="nospace clear">
           <c:forEach var="vo" items="${list }" varStatus="s">
            <c:choose>
             <c:when test="${s.index%4==0 }">
              <li class="one_quarter first"><a href="#"><img src="${vo.poster }" title="${vo.name }"></a></li>
             </c:when>
             <c:otherwise>
              <li class="one_quarter"><a href="#"><img src="${vo.poster }" title="${vo.name }"></a></li>
             </c:otherwise>
            </c:choose>
           </c:forEach>
            
          </ul>
          
        </figure>
      </div>
      <!-- class="current" ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
         <c:if test="${startPage>1 }">
          <li><a href="../food/food_find.do?page=${startPage-1}&fd=${fd}">&laquo; Previous</a></li>
         </c:if>
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
           <li ${i==curpage?"class=current":"" }><a href="../food/food_find.do?page=${i }&fd=${fd}">${i }</a></li>
         </c:forEach>
         <c:if test="${endPage<totalpage }"> 
          <li><a href="../food/food_find.do?page=${endPage+1}&fd=${fd}">Next &raquo;</a></li>
         </c:if>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>