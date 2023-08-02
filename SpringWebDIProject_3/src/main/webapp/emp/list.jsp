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
  width:450px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
   <form method=post action="info.do"> 
    <table class="table">
      <tr>
        <td>
          <c:forEach var="name" items="${list }">
            <input type="checkbox" name="names" value="${name }">${name }
          </c:forEach>
        </td>
      </tr>
      <tr>
        <td class="text-center">
         <button class="btn btn-sm btn-danger">검색</button>
        </td>
      </tr>
    </table>
    </form>
   </div>
  </div>
</body>
</html>