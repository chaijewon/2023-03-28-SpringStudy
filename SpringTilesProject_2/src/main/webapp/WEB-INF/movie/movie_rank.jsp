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
     <div class="text-center">
       <input type=button value="박스오피스" class="btn btn-sm btn-danger">
       <input type=button value="실시간 예매율" class="btn btn-sm btn-success">
       <input type=button value="좌석 점유율" class="btn btn-sm btn-info">
     </div>
    </div>
   </main>
</div>
</body>
</html>