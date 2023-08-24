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
</head>
<body>
 <div class="wrapper row3">
  <main class="container clear"> 
  <h2 class="sectiontitle">맛집 예약</h2>
    <div class="col-sm-4" style="height: 500px">
     <div class="row">
      <div class="inline text-center">
       <button class="btn btn-xs btn-danger" @click="changeMenu('한식')">한식</button>
       <button class="btn btn-xs btn-success" @click="changeMenu('중식')">중식</button>
       <button class="btn btn-xs btn-info" @click="changeMenu('양식')">양식</button>
       <button class="btn btn-xs btn-warning" @click="changeMenu('일식')">일식</button>
      </div>
     </div>
     <div style="height: 10px"></div>
     <div class="row" v-html="food_html" style="height: 450px;overflow-y:scroll">
      
     </div>
    </div>
    <div class="col-sm-4" style="height: 500px">Hello2</div>
    <div class="col-sm-4" style="height: 500px">Hello3</div>
    <div class="clear"></div>
    <div class="col-sm-4" style="height: 200px">Hello4</div>
    <div class="col-sm-4" style="height: 200px">Hello5</div>
  </main>
 </div>
 <script>
   new Vue({
	   el:'.container',
	   data:{
		   food_html:'',
		   date_html:'',
		   time_html:'',
		   inwon_html:'',
		   title:'한식'
	   },
	   mounted:function(){
		   this.dataSend()
	   },
	   methods:{
		   changeMenu:function(title){
			   this.title=title;
			   console.log(this.title)
			   this.dataSend()
		   },
		   dataSend:function(){
			   axios.get('../reserve/food_list.do',{
				   params:{
					   type:this.title
				   }  
			   }).then(res=>{
				   
			   })
			   
			   axios.get('../reserve/reserve_food_vue.do',{
				   params:{
					   type:this.title
				   }  
			   })
			   .then(res=>{
				   console.log(res.data)
				   this.food_html=res.data
			   })
			   .catch(error=>{
				   console.log(error.response)
			   })
		   }
	   }
   })
 </script>
</body>
</html>