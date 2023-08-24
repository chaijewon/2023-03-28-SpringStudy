<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/2020/swiper.min.css?bust=20221228_01" class="css">
<link rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/2019/animate.css?bust=20221228_01"/>
<link rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/2019/content.css?bust=20230712_01"/>
<link rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/2019/layout.css?bust=20221228_01"/>
<link rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/content.css?dt=20221228_01"/>
<link rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/seoul_stay.css?bust=20221228_01"/>
<link type="text/css" rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/malay/common.css">
<link type="text/css" rel="stylesheet" href="https://korean.visitseoul.net//resources/theme/style/malay/sub.css">
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.tbcon01,.tbcon02,.tbcon03{
   color:black;
}
.row{
  margin: 0px auto;
  width:850px;
}
</style>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear">
   <h2 class="sectiontitle">오늘의 날씨</h2>
   <div class="row" v-html="html">
   
   </div>
  </main>
 </div>
 <script>
   new Vue({
	   el:'.container',
	   data:{
		   html:''
	   },
	   mounted:function(){
		   axios.get('../weather/weather_vue.do').then(res=>{
				   this.html=res.data
		   })
	   }
   })
 </script>
</body>
</html>