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
    <h2 class="sectiontitle">등록하기</h2>
    <div class="row">
     <form @submit.prevent="submitForm">
     <table class="table">
       <tr>
        <th width=15%>이름</th>
        <td width=85%>
         <input type=text ref="name" v-model="name" class="input-sm" size=20>
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
        <th width=15%>첨부파일</th>
        <td width=85%>
         <input type=file ref="images" v-model="images" class="input-sm" multiple accept="upload/*">
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
          <input type=submit value="등록" class="btn btn-sm btn-danger">
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
		   name:'',
		   subject:'',
		   content:'',
		   pwd:'',
		   images:''
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
			   
			   let leng=this.$refs.images.files.length;
			   if(leng>0)
			   {
				   for(let i=0;i<this.$refs.images.files.length;i++)
				   {
					   form.append("images["+i+"]",this.$refs.images.files[i])
				   }
			   }
			   
			   
			   axios.post('../databoard/insert_vue.do',form,{
				   header:{
					   'Context-Type':'multipart/form-data'
				   }
			   }).then(response=>{
				   location.href="../databoard/list.do"
			   }).catch(error=>{
				   console.log(error.response);
			   })
		   }
	   }
   })
  </script>
</body>
</html>