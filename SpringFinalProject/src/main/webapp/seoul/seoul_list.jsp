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
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">{{title}}</header>
          <ul class="nospace clear">
            <li v-for="vo,index in seoul_list" :class="index%4==0?'one_quarter first':'one_quarter'"><a href="#"><img :src="vo.poster" :title="vo.title" style="width:300px;height: 150px"></a></li>
          </ul>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
          <li v-if="startPage>1"><a href="#" @click="prev()">&laquo; Previous</a></li>
          <li v-for="i in range(startPage,endPage)" :class="i==curpage?'current':''">
          <a href="#" @click="pageChange(i)">{{i}}</a></li>
          <li v-if="endPage<totalpage"><a href="#" @click="next()">Next &raquo;</a></li>
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
    		 type:${type},
    		 title:'${title}',
    		 seoul_list:[],
    		 page_info:{},
    		 curpage:1,
    		 totalpage:0,
    		 startPage:0,
    		 endPage:0
    	 },
    	 mounted:function(){
    		 this.dataRecv()
    	 },
    	 methods:{
    		 dataRecv:function(){
    			 axios.get('http://localhost/web/seoul/seoul_list_vue.do',{
    				 params:{
    					 page:this.curpage,
    					 type:this.type
    				 }
    			 }).then(response=>{
    				 console.log(response.data)
    				 this.seoul_list=response.data
    			 }).catch(error=>{
    				 console.log(error.response);
    			 })
    			 
    			 //  페이지 읽기
    			 axios.get('http://localhost/web/seoul/seoul_page_info_vue.do',{
    				 params:{
    					 page:this.curpage,
    					 type:this.type
    				 }
    			 }).then(res=>{
    				 console.log(res.data)
    				 this.page_info=res.data
    				 this.curpage=this.page_info.curpage
    				 this.totalpage=this.page_info.totalpage
    				 this.startPage=this.page_info.startPage
    				 this.endPage=this.page_info.endPage
    			 }).catch(error=>{
    				 console.log(error.response)
    			 })
    		 },
    		 range:function(start,end){
    			 let arr=[];
    			 let leng=end-start;
    			 for(let i=0;i<=leng;i++)
    			 {
    				 arr[i]=start;
    				 start++;
    			 }
    			 return arr;
    		 },
    		 pageChange:function(page){
    			 this.curpage=page;
    			 this.dataRecv()
    		 },
    		 prev:function(){
    			 this.curpage=this.startPage-1
    			 this.dataRecv()
    		 },
    		 next:function(){
    			 this.curpage=this.endPage+1
    			 this.dataRecv()
    		 }
    	 }
     })
  </script>
</body>
</html>