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
    <h2 class="sectiontitle">회원가입</h2>
    <div class="row">
     <form method="post" action="../member/join_ok.do" @submit="submitForm">
      <table class="table">
        <tr>
         <th class="text-right" width=10%>ID</th>
         <td width=90% class="inline">
          <input type=text name=id ref="u_id" size=20 class="input-sm"
           v-model="u_id" @keyup="idCheck" v-bind:readonly="isDisabled">
          <!-- <input type=button value="중복체크" class="btn btn-sm btn-success" ref="id" v-model="id" @blur="idCheck"> -->
          <p>{{idOk}}</p>
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>비밀번호</th>
         <td width=90% class="inline">
          <input type=password name=pwd ref="u_pwd" size=20 class="input-sm" v-model="u_pwd"
            @keyup="pwdValidate"
          >
          &nbsp;재입력:<input type=password name=pwd1 ref="u_pwd1" size=20 
          class="input-sm" @keyup="pwdValidate2" v-model="u_pwd1">
          <p>{{pwdOk}}</p>
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>이름</th>
         <td width=90% class="inline">
          <input type=text name=name ref="u_name" size=20 class="input-sm"
           v-model="u_name"
          >
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>성별</th>
         <td width=90% class="inline">
          <input type="radio" name=sex value="남자" checked
           ref="u_sex" v-model="u_sex"
          >남자
          <input type="radio" name=sex value="여자"
            ref="u_sex" v-model="u_sex"
          >여자
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>생년월일</th>
         <td width=90% class="inline">
          <input type="date" name=birthday size=20
           ref="u_birthday" v-model="u_birthday"
          >
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>이메일</th>
         <td width=90% class="inline">
          <input type=text name=email ref="u_email" size=55 class="input-sm"
           v-model="u_email"
           @keyup="emailCheck"
          >
          <p>{{emailOk}}</p>
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>우편번호</th>
         <td width=90% class="inline">
          <input type=text ref="u_post" v-model="u_post" size=10 class="input-sm" name="post">
          <input type=button value="우편번호검색" class="btn btn-sm btn-info"
            v-on:click="postFind()">
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>주소</th>
         <td width=90% class="inline">
          <input type=text ref="u_addr1" v-model="u_addr1" size=55 class="input-sm"
           readonly name="addr1"
          >
         </td>
        </tr>
        
        <tr>
         <th class="text-right" width=10%>상세주소</th>
         <td width=90% class="inline">
          <input type=text name=addr2 ref="u_addr2" size=55 class="input-sm"
           v-model="u_addr2"
          >
         </td>
        </tr>
       
        <tr>
         <th class="text-right" width=10%>전화</th>
         <td width=90% class="inline">
          <select name=phone1 class="input-sm" ref="u_phone1" v-model="u_phone1">
           <option>010</option>
          </select>
          <input type=text name=phone ref="u_phone" size=12 class="input-sm"
            v-model="u_phone"
          >
          <input type=button value="전화체크" 
            class="btn btn-sm btn-warning" id="phoneBtn">
         </td>
        </tr> 
       
        <tr>
         <th class="text-right" width=10%>소개</th>
         <td width=90% class="inline">
          <textarea rows="10" cols="55" name=content ref="u_content"
           v-model="u_content"
          ></textarea>
         </td>
        </tr> 
        
        <tr>
          <td colspan="2" class="text-center">
           <input type="submit" value="회원가입" 
             class="btn btn-success btn-sm" id="joinBtn">
           <input type=button value="취소"
             class="btn btn-info btn-sm" onclick="javascript:history.back()">
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
		  u_id:'',
		  u_pwd:'',
		  u_pwd1:'',
		  u_name:'',
		  u_sex:'',
		  u_birthday:'',
		  u_email:'',
		  u_post:'',
		  u_addr1:'',
		  u_addr2:'',
		  u_phone1:'010',
		  u_phone:'',
		  u_content:'',
		  idOk:'',
		  pwdOk:'',
		  pwdOk2:'',
		  emailOk:'',
		  phoneOk:'',
		  isDisabled:false
	  },
	  methods:{
		  submitForm:function(e){
			  if(this.u_id && this.u_name && this.u_pwd && this.u_pwd1 
			  && this.u_sex && this.u_email && this.u_birthday 
			  && this.u_post && this.u_addr1 && this.u_phone1 && this.u_phone
			  && !this.idOk && !this.emailOk)
		      {
				  return true;
		      }
			  
			  if(this.u_id=='' || this.idOk!='')
			  {
				  
				  this.$refs.u_id.focus();
			  }
			  else if(this.u_name=='')
			  {
				  this.$refs.u_name.focus()
			  }
			  else if(this.u_pwd=='')
			  {
				  this.$refs.u_pwd.focus()
			  }
			  else if(this.u_pwd1=='')
			  {
				  this.$refs.u_pwd1.focus()
			  }
			  else if(this.u_pwd != this.u_pwd1)
			  {
				  this.u_pwd='';
				  this.u_pwd2='';
			  }
			  else if(this.u_email=='' && this.emailOk!='')
			  {
				  this.$refs.u_email.focus()
			  }
			  else if(this.u_phone=='')
			  {
				  this.$refs.u_phone.focus()
			  }
			  else if(this.u_post=='')
			  {
				  alert('우편번호를 찾기를 하세요')
			  }
			  else if(this.u_phone=='')
			  {
				  this.$refs.u_phone.focus()
			  }
			  e.preventDefault()
		  },
		  postFind:function(){
			  let _this=this;
			  new daum.Postcode({
				 oncomplete:function(data){
				            _this.u_post=data.zonecode;
				            _this.u_addr1=data.address;
				 }
			  }).open()
		  },
		  idCheck:function(){
			  if(this.u_id!=='')
			  {
				  axios.get("http://localhost/web/member/idcheck_ok_vue.do",{
					  params:{
						  id:this.u_id
					  }
				  }).then(res=>{
					  if(res.data=='no')
					  {
						  this.idOk='이미 존재하는 아이디입니다'
					  }
					  else
					  {
						  this.idCheckValidate(res.data)
						  
					  }
				  })
			  }
			  else
			  {
				  this.idOk=''
				  
			  }	  
			
		  },
		  idCheckValidate:function(id){
			  console.log(id)
			  let id_res=String(id)
			  let num=id_res.search(/[0-9]/g)
			  let eng=id_res.search(/[a-z]/ig)
			  if(id_res.length<6 || id_res.length>12)
			  {
				  this.idOk='아이디는 6자리~12자리 이내로 입력해 주세요'
				  return;
			  }
			  else if(id_res.search(/\s/)!=-1)
			  {
				  // 공백 찾기
				  this.idOk='아이디는 공백 없이 입력해주세요'
				  return;
			  }
			  else if(num<0 || eng < 0)
			  {
				 this.idOk='아이디는 영문 , 숫자를 혼합하여 입력해주세요'
				 return;
			  }
			  else
			  {
				  this.idOk='';
				  this.isDisabled=true
				  return;
			  }
		  },
		  pwdValidate:function(){
			  let pwd=String(this.u_pwd);
			  let num=pwd.search(/[0-9]/g)
			  let eng=pwd.search(/[a-z]/ig)
			  if(pwd==='')
			  {
				  this.pwdOk='';
				  return;
			  }
			  if(pwd.length<8 || pwd.length>20)
			  {
				  this.pwdOk='비밀번호는 8자리~20자리 이내로 입력하세요'
				  return;
			  }
			  else if(pwd.search(/\s/)!=-1)
			  {
				  this.pwdOk='비밀번호는 공백없이 입력하세요'
				  return;
			  }
			  else if(num<0 || eng<0)
			  {
				  this.pwdOk='비밀번호는 영문,숫자를 혼합해서 입력하세요'
				  return;
			  }
			  else
		      {
				  this.pwdOk='';
				  return;
			  }
		  },
		  pwdValidate2:function(){
			  if(this.u_pwd!=this.u_wd1)
			  {
				  this.pwdOk='재입력이 일치하지 않습니다'
			  }
			  else
			  {
				  this.pwdOk=''
			  }
		  },
		  emailCheck:function(){
			  if(this.u_email!='')
			  {
				  axios.get('http://localhost/web/member/email_check_vue.do',{
					  params:{
						  email:this.u_email
					  }
				  }).then(res=>{
					  if(res.data=='no')
					  {
						  this.emailOk='이미 존재하는 이메일입니다'
					  }
					  else
					  {
						  this.emailValidate(res.data)  
					  }
				  })
			  }
			  else
			  {
				  this.emailOk='';
			  }
		  },
		  emailValidate:function(email){
			  let re=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
			  if(!re.test(this.u_email))
			  {
				  // test() => 정규식을 비교할 때 사용 
				  this.emailOk="이메일 형식이 올바르지 못합니다"
			  }
			  else
			  {
				  this.emailOk=''
			  }
		  }
	  }
   })
  </script>
</body>
</html>