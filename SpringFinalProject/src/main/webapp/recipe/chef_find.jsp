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
    <!-- main body --> 
    <table class="table">
     <tr>
       <td width=30% class="text-center" rowspan="2">
         <img :src="chef_info.poster" style="width:90px;height: 90px" class="img-circle">
       </td>
       <td width=70% colspan="4"><h4 style="color:orange">{{chef_info.chef}}</h4></td>
     </tr>
     <tr>
       <td class="text-center">
        <img src="../recipe/images/mem1.png">&nbsp;{{chef_info.mem_cont1}}
       </td>
       <td class="text-center">
        <img src="../recipe/images/mem2.png">&nbsp;{{chef_info.mem_cont2}}
       </td>
       <td class="text-center">
        <img src="../recipe/images/mem7.png">&nbsp;{{chef_info.mem_cont4}}
       </td>
       <td class="text-center">
        <img src="../recipe/images/mem3.png">&nbsp;{{chef_info.mem_cont3}}
       </td>
     </tr>
    </table>
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading inline">
           <input type=text size=20 ref="fd" class="input-sm" v-model="fd">
           <input type=button value="검색" class="btn btn-sm btn-danger">
          </header>
          <ul class="nospace clear">
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
          </ul>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
          <li><a href="#">&laquo; Previous</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><strong>&hellip;</strong></li>
          <li><a href="#">6</a></li>
          <li class="current"><strong>7</strong></li>
          <li><a href="#">8</a></li>
          <li><a href="#">9</a></li>
          <li><strong>&hellip;</strong></li>
          <li><a href="#">14</a></li>
          <li><a href="#">15</a></li>
          <li><a href="#">Next &raquo;</a></li>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
  <script>
   new Vue({
	   el:'.container',
	   data:{
		   chef_info:{},
		   food_list:[],
		   curpage:1,
		   totalpage:0,
		   startPage:0,
		   endPage:0,
		   chef:'${chef}',
		   fd:''
	   },
	   // EL , JSTL = 자바스크립트에서 사용이 가능 
	   mounted:function(){
		   axios.get('http://localhost/web/recipe/chef_info_vue.do',{
			   params:{
				   chef:this.chef
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.chef_info=response.data
		   }).catch(error=>{
			   console.log(error.response)
		   })
	   },
	   methods:{
		   
	   }
   })
  </script>
</body>
</html>