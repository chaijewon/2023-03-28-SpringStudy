<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width:100%;
}
</style>
</head>
<body>
<div class="wrapper row3">
   <main class="container clear">
    <h2 class="sectiontitle">${name } 상세보기</h2>
    <div class="row">
      <table class="table">
       <tr>
        <td class="text-center">
          <h3>${vo.title }</h3>
        </td>
       </tr>
       <tr>
         <td class="text-center">
          <img src="${vo.poster }" style="width: 100%">
         </td>
       </tr>
       <tr>
         <td>${vo.msg }</td>
       </tr>
       <tr>
         <td>${vo.address }</td>
       </tr>
       <tr>
         <td class="text-right">
          <a href="../seoul/list.do?no=${no}" class="btn btn-sm btn-primary">목록</a>
         </td>
       </tr>
      </table>
    </div>
   </main>
</div>
</body>
</html>





