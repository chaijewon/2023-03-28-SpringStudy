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
  <div class="jumbotron">
    <h3 class="text-center">${cvo.title }</h3>
    <h4 class="text-center">${cvo.subject }</h4>
  </div>
  <div class="row">
    <table class="table">
     <tr>
       <td>
         <c:forEach var="vo" items="${list }">
           <table class="table">
            <tr>
              <td width=30% class="text-center" rowspan="4">
                <a href="../food/food_before_detail.do?fno=${vo.fno }">
                <img src="${vo.poster }" style="width:290px;height:180px" class="img-rounded">
                </a>
              </td>
              <td width=70%>
                <h3><a href="../food/food_before_detail.do?fno=${vo.fno }">${vo.name }</a>&nbsp;<span style="color:orange">${vo.score }</span></h3>
              </td>
            </tr>
            <tr>
              <td width=70%>${vo.address }</td>
            </tr>
            <tr>
              <td width=70%>${vo.phone }</td>
            </tr>
            <tr>
              <td width=70%>${vo.type }</td>
            </tr>
           </table>
         </c:forEach>
       </td>
     </tr>
    </table>
  </div>
</body>
</html>