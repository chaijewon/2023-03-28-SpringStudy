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
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 900px;
}
input[type="text"]{
  width: 300px;
}
</style>
</head>
<body>
  <div class="container">
    <h1 class="text-center">{{music_title}}</h1>
    <div class="row">
     <div class="text-center">
      <b-button variant="outline-danger" @click="musicGetData(1)">Top100</b-button>
      <b-button variant="outline-success" @click="musicGetData(2)">가요</b-button>
      <b-button variant="outline-warning" @click="musicGetData(3)">POP</b-button>
      <b-button variant="outline-info" @click="musicGetData(4)">OST</b-button>
      <b-button variant="outline-primary" @click="musicGetData(5)">트롯</b-button>
      <b-button variant="outline-default" @click="musicGetData(6)">JAZZ</b-button>
      <b-button variant="outline-danger" @click="musicGetData(7)">CLASSIC</b-button>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <input type=text ref="fd" class="input-sm"  placeholder="검색어 입력" id="keyword"
       v-on:keyup="selectMusic()"
      >
    </div>
    <div style="height: 10px"></div>
    <div class="row">
      <table class="table table-striped" id="user-table">
       <thead>
        <tr class="danger">
         <th class="text-center">순위</th>
         <th class="text-center"></th>
         <th class="text-center">곡명</th>
         <th class="text-center">가수명</th>
        </tr>
       </thead>
       <tbody>
        <tr v-for="vo in music_list">
         <td class="text-center">{{vo.mno}}</th>
         <td class="text-center">
          <img :src="vo.poster" style="width: 30px;height: 30px">
         </th>
         <td>{{vo.title}}</th>
         <td>{{vo.singer}}</th>
        </tr>
       </tbody>
      </table>
    </div>
  </div>
  <script>
   new Vue({
	   el:'.container',
	   data:{
		   cno:1,
		   music_list:[],
		   music_detail:{},
		   music_title:''
	   },
	   mounted:function(){
		   this.musicGetData(1);
		   //Jquery나 다른 라이브러이 연동 
		   //$(function(){===mounted===})
		   $('#keyword').keyup(function(){
			   let k=$(this).val();
			   $('#user-table > tbody > tr').hide();
			   let temp=$('#user-table > tbody > tr > td:nth-child(4n+3):contains("'+k+'")')
			   $(temp).parent().show()
		   })
	   },
	   methods:{
		   musicGetData:function(cno)
		   {
			   axios.get('http://localhost/web/music/list_vue.do',{
				   params:{
					   cno:cno
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.music_list=response.data
				   this.music_title=response.data[0].music_title
			   })
		   }
	   }
   })
  </script>
</body>
</html>