<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
     
    </div>
    <div style="height: 10px"></div>
    <div class="row">
      
    </div>
    <h3>최근 방문 상품</h3>
    <hr>
    <div class="row">
      
    </div>
  </div>
  <script>
   new Vue({
	   el:'.container-fluid',
	   data:{
		   goods_list:[],
		   curpage:1,
		   totalpage:0,
		   startPage:0,
		   endPage:0,
		   goods_cookie:[]
	   }
   })
  </script>
</body>
</html>



