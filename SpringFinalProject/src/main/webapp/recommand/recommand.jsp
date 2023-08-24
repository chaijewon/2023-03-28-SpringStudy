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
        <button class="btn btn-lg btn-danger" @click="change(1)">계절/날씨</button>
        <button class="btn btn-lg btn-success" @click="change(2)">감성</button>
        <button class="btn btn-lg btn-primary" @click="change(3)">스타일</button>
      </div>
      <div style="height: 15px"></div>
      <div class="row">
        <div class="text-center">
         <span class="btn btn-sm btn-info" v-for="m in sub_list" 
         style="margin-left: 3px;margin-top: 3px" @click="recommand(m)">{{m}}</span>
        </div>
      </div>
      <div style="height: 15px"></div>
      <div class="row">
        <div class="text-center">
          <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="vo.poster" style="width:100%">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
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
		  this.sub()
	   },
	   methods:{
		   change:function(no){
			   this.no=no
			   this.sub()
		   },
		   sub:function(){
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
		   },
		   recommand:function(title){
			   axios.get('../recommand/recommand_vue.do',{
				   params:{
					   fd:title
				   }
			   }).then(res=>{
				   console.log(res.data)
				   this.food_list=res.data
			   }).catch(error=>{
				   console.log(error.response)
			   })
		   }
	   }
   })
 </script>
</body>
</html>