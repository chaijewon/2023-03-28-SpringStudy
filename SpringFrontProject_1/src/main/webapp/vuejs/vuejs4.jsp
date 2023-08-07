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
.container{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 960px;
}
</style>
</head>
<body>
  <div class="container">
   <h1 class="text-center">디렉티브(v-if:조건문,v-show)</h1>
   <div class="row">
     <ul>
      <%--
         <c:forEach var="vo" items="${list}" varStatus="s">
       --%>
      <li v-for="name,index in names" v-if="name!=='홍길동'">{{index+1}}.{{name}}</li>
      <!-- <li v-else>{{{{name}}</li> -->
     </ul>
     이름:{{detail.name}}<br>
     성별:{{detail.sex}}<br>
     나이:{{detail.age}}<br>
     주소:{{detail.addr}}<br>
     전화:{{detail.phone}}
     <p>{{$data}}</p>
   </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		names:['홍길동','심청이','박문수','이순신','강감찬'],
    		detail:{"name":'홍길동',"sex":'남자',"age":25,"addr":'서울',"phone":'010-1111-1111'}
    	}
    })
  </script>
</body>
</html>





