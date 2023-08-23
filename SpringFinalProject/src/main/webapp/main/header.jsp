<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">Spring Food</a></h1>
    </div>
    <div class="fl_right">
     <c:if test="${sessionScope.id==null }">
      <ul class="inline">
        <li>ID:<input type="text" size=15 class="input-sm" ref="login_id" v-model="login_id"></li>
        <li>PW:<input type="password" size=15 class="input-sm" ref="login_pwd" v-model="login_pwd"></li>
        <li><input type=button value="로그인" class="btn-sm" @click="login()">
      </ul>
      <ul class="inline">
        <li>아이디 저장:<input type="checkbox" ref="ck" v-model="ck"></li>
        <li>현재 시간:${today }</li>
      </ul>
     </c:if>
     <c:if test="${sessionScope.id!=null }">
      <ul class="inline">
        <li>${sessionScope.name}님 로그인중입니다</li>
        <li><input type=button value="로그아웃" class="btn-sm" @click="logout()">
      </ul>
     </c:if>
    </div>
  </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    
    <ul class="clear">
      <li class="active"><a href="../main/main.do">HOME</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="../member/join.do">회원가입</a></li>
          <li><a href="pages/full-width.html">아이디찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀번호찾기</a></li>
        </ul>
      </li>
      <!-- <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="pages/gallery.html">회원수정</a></li>
          <li><a href="pages/full-width.html">회원탈퇴</a></li>
        </ul>
      </li>-->
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../food/food_find.do">지역별 맛집 찾기</a></li>
          <li><a href="../recommand/recommand.do">맛집 추천</a></li>
          <li><a href="pages/sidebar-left.html">맛집 예약</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="../recipe/recipe_list.do">레시피</a></li>
          <li><a href="../recipe/chef_list.do">쉐프</a></li>
          <li><a href="../recipe/recipe_make.do">레시피 만들기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">서울 여행</a>
        <ul>
          <li><a href="../seoul/seoul_list.do?type=1">명소</a></li>
          <li><a href="../seoul/seoul_list.do?type=2">자연</a></li>
          <li><a href="../seoul/seoul_list.do?type=3">쇼핑</a></li>
          <li><a href="pages/sidebar-left.html">지역별 코스</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="pages/gallery.html">공지사항</a></li>
          <li><a href="../databoard/list.do">자유게시판</a></li>
        </ul>
      </li>
      <li><a href="../chat/chat.do">실시간 채팅</a></li>
    </ul>
    
  </nav>
</div>
<script>
  let header=new Vue({
	  el:'#header',
	  data:{
		  login_id:'${id}',
		  login_pwd:'',
		  ck:true
	  },
	  methods:{
		  logout:function(){
			axios.get('http://localhost/web/member/logout_vue.do')
			.then(res=>{
				location.href="../main/main.do"
			})
		  },
		  login:function(){
			  //alert("aaa")
			  if(this.login_id==='')
			  {
				  alert("아이디를 입력하세요")
				  this.$refs.login_id.focus();
				  return;
			  }
			  if(this.login_pwd==='')
			  {
				  alert("비밀번호를 입력하세요")
				  this.$refs.login_pwd.focus();
				  return
			  }
			     axios.post('http://localhost/web/member/login_ok_vue.do',null,{
					  params:{
						  id:this.login_id,
						  pwd:this.login_pwd,
						  ck:this.ck
						  
					  }
				  }).then(res=>{
					  if(res.data==='NOID')
					  {
						  alert('아이디가 존재하지 않습니다')
						  this.login_id=''
						  this.login_pwd=''
						  this.$refs.login_id.focus()
					  }
					  else if(res.data==='NOPWD')
					  {
						  alert("비밀번호가 틀립니다")
						  this.login_pwd=''
						  this.$refs.login_pwd.focus()
					  }
					  else
					  {
						  //this.sessionId=res.data
						  location.href="../main/main.do"
					  }
				  })
			  
		  }
	  }
  })
</script>
</body>
</html>