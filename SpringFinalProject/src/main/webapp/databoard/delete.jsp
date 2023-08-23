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
  width:350px;
}
</style>
</head>
<body>
  <div class="wrapper row3">
   <main class="container clear">
    <h2 class="sectiontitle">삭제하기</h2>
    <div class="row">
      <table class="table">
       <tr>
        <td class="inline">
          비밀번호:<input type=password class="input-sm" ref="pwd" v-model="pwd" size=20>
        </td>
       </tr>
       <tr>
         <td class="text-center">
          <input type=button value="삭제" class="btn btn-sm btn-danger"
           @click="del">
          <input type=button value="취소" class="btn btn-sm btn-success"
          onclick="javascript:history.back()">
         </td>
       </tr>
      </table>
    </div>
   </main>
 </div>
 <script>
   new Vue({
	   el:'.container',
	   data:{
		   no:${param.no},
		   pwd:''
	   },
	   methods:{
		   del:function(){
			   if(this.pwd==="")
			   {
				   this.$refs.pwd.focus();
				   return
			   }
			   axios.get('../databoard/delete_ok_vue.do',{
				   params:{
					   no:this.no,
					   pwd:this.pwd
				   }
			   }).then(response=>{
				   console.log(response.data)
				   let result=response.data
				   if(result==='yes')
				   {
					   location.href="../databoard/list.do"
				   }
				   else
				   {
					   alert("비밀번호가 틀립니다")
					   this.pwd="";
					   this.$refs.pwd.focus()
				   }
			   }).catch(error=>{
				   console.log(error.response)
			   })
		   }
	   }
   })
 </script>
</body>
</html>