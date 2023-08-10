<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
.container-fluid{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
.images:hover{
  cursor: pointer
}
td{
  font-size: 9px
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
      <div class="text-right">
       ${sessionScope.name }님 로그인 중입니다 <a href="../member/logout.do" class="btn-btn-sm btn-danger">로그아웃</a>
      </div>
    </div>
    <div class="row">
      <div class="text-center">
        <button class="btn btn-sm btn-danger" @click="categoryGetData(1)">믿고보는 맛집 리스트</button>
        <button class="btn btn-sm btn-info" @click="categoryGetData(2)">지역별 맛집 리스트</button>
        <button class="btn btn-sm btn-success" @click="categoryGetData(3)">메뉴별 인기 맛집</button>
      </div>
    </div>
    <div style="height: 10px"></div>
    <div class="row">
     <div class="col-sm-7">
     <div class="col-md-4" v-for="vo in cate_list">
		    <div class="thumbnail">
		        <img :src="vo.poster" style="width:100%" class="images" @click="foodGetList(vo.cno,true)">
		        <div class="caption">
		          <p style="font-size: 9px">{{vo.title}}</p>
		        </div>
		    </div>
		</div>
		<div style="height: 30px"></div>
		<h4>최근 방문 맛집</h4>
		<hr>
	  </div>
	  <div class="col-sm-5" v-show="isShow">
	    <div class="jumbotron">
	     <h5 class="text-center">{{cate_info.title}}</h5>
	     <h6 class="text-center">{{cate_info.subject}}</h6>
	    </div>
	    <table class="table">
	      <tr>
	       <td>
	         <table class="table" v-for="fvo in food_list">
	          <tr>
	           <td width=30% class="text-center" rowspan="4">
	             <img :src="fvo.poster" style="width:150px;height: 100px">
	           </td>
	           <td width=70%><h6>{{fvo.name}}&nbsp;<span style="color:orange">{{fvo.score}}</span></h6></td>
	          </tr>
	          <tr>
	            <td width=70%>{{fvo.address}}</td>
	          </tr>
	          <tr>
	            <td width=70%>{{fvo.phone}}</td>
	          </tr>
	          <tr>
	            <td width=70%>{{fvo.type}}</td>
	          </tr>
	         </table>
	       </td>
	      </tr>
	    </table>
	  </div>
    </div>
  </div>
  <script>
   new Vue({
	   el:'.container-fluid',
	   data:{
		   cate_list:[],
		   food_list:[],
		   cate_info:{},
		   isShow:false
	   },
	   // 생성자=>초기화면 출력 
	   mounted:function(){
		   this.categoryGetData(1);
	   },
	   methods:{
		   categoryGetData:function(cno){
			   axios.get('../food/food_category_vue.do',{
				   params:{
					   cno:cno
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.cate_list=response.data
			   }).catch(error=>{
				   console.log(error.response)
			   })
		   },
		   foodGetList:function(cno,bool){
			   this.isShow=bool;
			   axios.get("../food/food_category_info_vue.do",{
				   params:{
					   cno:cno
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.cate_info=response.data
			   }).catch(error=>{
				   console.log(error.response)
			   })
			   
			   axios.get("../food/food_list_vue.do",{
				   params:{
					   cno:cno
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.food_list=response.data
			   }).catch(error=>{
				   console.log(error.response)
			   })
		   }
	   }
   })
  </script>
</body>
</html>



