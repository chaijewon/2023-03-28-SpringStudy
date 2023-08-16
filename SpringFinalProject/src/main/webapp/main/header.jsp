<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">Spring Food</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
        <li>ID:<input type="text" size=15 class="input-sm" ref="login_id"></li>
        <li>PW:<input type="password" size=15 class="input-sm" ref="login_pwd"></li>
        <li><input type=button value="로그인" class="btn-sm">
      </ul>
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
          <li><a href="pages/gallery.html">지역별 맛집 찾기</a></li>
          <li><a href="pages/full-width.html">맛집 추천</a></li>
          <li><a href="pages/sidebar-left.html">맛집 예약</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="pages/gallery.html">레시피</a></li>
          <li><a href="pages/full-width.html">쉐프</a></li>
          <li><a href="pages/sidebar-left.html">레시피 만들기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">서울 여행</a>
        <ul>
          <li><a href="pages/gallery.html">명소</a></li>
          <li><a href="pages/full-width.html">자연</a></li>
          <li><a href="pages/sidebar-left.html">쇼핑</a></li>
          <li><a href="pages/sidebar-left.html">지역별 코스</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="pages/gallery.html">공지사항</a></li>
          <li><a href="pages/full-width.html">자유게시판</a></li>
        </ul>
      </li>
      <li><a href="../chat/chat.do">실시간 채팅</a></li>
    </ul>
    
  </nav>
</div>
</body>
</html>