<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width:850px;
}
</style>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
  <h2 class="sectiontitle">맛집 추천</h2>
    <div class="row">
      <div class="text-center">
        <button class="btn btn-lg btn-danger">계절/날씨</button>
        <button class="btn btn-lg btn-success">감성</button>
        <button class="btn btn-lg btn-info">스타일</button>
      </div>
      <div style="height: 15px"></div>
      <div class="row">
        <div class="text-center">
         <span class="btn btn-sm btn-danger" v-for="m in sub_list">{{m}}</span>
        </div>
      </div>
      <div style="height: 15px"></div>
      <div class="row">
        <div class="text-center">
         
        </div>
      </div>
    </div>
  </main>
 </div>
 <script>
   new Vue({
	   el:'.container',
	   data:{
		   no:1,
		   sub_list:[],
		   food_list:[]
	   },
	   mounted:function(){
		   axios.get('../recommand/recommand_sub_vue.do',{
			  params:{
				  no:this.no
			  }   
		   }).then(res=>{
			   console.log(res.data)
			   this.sub_list=res.data
		   }).catch(error=>{
			   console.log(error.response)
		   })
	   }
   })
 </script>
</body>
</html>