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
  width:800px;
}
</style>
</head>
<body>
  <div class="wrapper row3">
   <main class="container clear">
    <h2 class="sectiontitle">수정하기</h2>
    <div class="row">
     <form @submit.prevent="submitForm">
     <table class="table">
       <tr>
        <th width=15%>이름</th>
        <td width=85%>
         <input type=text ref="name" class="input-sm" size=20 v-model="name">
        </td>
       </tr>
       <tr>
        <th width=15%>제목</th>
        <td width=85%>
         <input type=text ref="subject" v-model="subject" class="input-sm" size=55>
        </td>
       </tr>
       <tr>
        <th width=15%>내용</th>
        <td width=85%>
         <textarea rows="10" cols="55" ref="content" v-model="content"></textarea>
        </td>
       </tr>
       <tr>
        <th width=15%>비밀번호</th>
        <td width=85%>
         <input type=password ref="pwd" v-model="pwd" class="input-sm" size=15>
        </td>
       </tr>
       <tr>
         <td class="text-center" colspan="2">
          <input type=submit value="수정" class="btn btn-sm btn-danger">
          <input type=button value="취소" class="btn btn-sm btn-success"
          onclick="javascript:history.back()">
         </td>
       </tr>
     </table>
    </form> 
    </div>
   </main>
  </div>
  <script>
   new Vue({
	   el:'.container',
	   data:{
		   no:${param.no},
		   name:'',
		   subject:'',
		   content:'',
		   pwd:'',
		   update_data:{}
	   },
	   mounted:function(){
		 // 데이터 읽기 
		 axios.get('../databoard/update_vue.do',{
			 params:{
				 no:this.no
			 }
		 }).then(response=>{
			 console.log(response.data)
			 this.update_data=response.data;
			 this.name=response.data.name
			 this.subject=response.data.subject
			 this.content=response.data.content
			 
		 }).catch(error=>{
			 console.log(error.response)
		 })
	   },
	   methods:{
		   submitForm:function(){
			   if(this.name=="")
			   {
				   this.$refs.name.focus();
				   return;
			   }
			   if(this.subject=="")
			   {
				   this.$refs.subject.focus();
				   return;
			   }
			   if(this.content=="")
			   {
				   this.$refs.content.focus();
				   return;
			   }
			   if(this.pwd=="")
			   {
				   this.$refs.pwd.focus();
				   return;
			   }
			   let form=new FormData();
			   form.append("name",this.name);
			   form.append("subject",this.subject);
			   form.append("content",this.content);
			   form.append("pwd",this.pwd);
			   form.append("no",this.no)
			  
			   axios.post('../databoard/update_ok_vue.do',form).then(response=>{
				   
				   let result=response.data;
				   if(result==="yes")
				   {
					   location.href="../databoard/detail.do?no="+this.no
				   }
				   else
				   {
					   alert("비밀번호가 틀립니다!!")
					   this.pwd='';
					   this.$refs.pwd.focus();
				   }
			   }).catch(error=>{
				   console.log(error.response);
			   })
		   }
	   }
   })
  </script>
</body>
</html>