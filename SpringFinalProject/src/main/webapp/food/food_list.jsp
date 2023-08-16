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
  width:100%;
}
</style>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
 <div class="wrapper row3">
   <main class="container clear">
    <div class="jumbotron">
     <h3 class="text-center">{{cate_info.title}}</h3>
     <h4 class="text-center">{{cate_info.subject}}</h4>
    </div>
    <div class="row">
    </div>
   </main>
 </div>
<script>
   new Vue({
	   el:'.container',
	   data:{
		   cno:${cno},
		   food_list:[],
		   cate_info:{}
	   },
	   mounted:function(){
		   axios.get('http://localhost/web/food/category_info_vue.do',{
			   params:{
				   cno:this.cno
			   }	   
		   }).then(res=>{
			   console.log(res.data)
			   this.cate_info=res.data
		   })
		   /*
		   axiox.get('http://localhost/web/food/food_list_vue.do',{
			   params:{
				   cno:this.cno
			   }	   
		   }).then(res=>{
			   this.food_list=res.data
		   })
		   */
	   }
   }) 
</script>
</body>
</html>