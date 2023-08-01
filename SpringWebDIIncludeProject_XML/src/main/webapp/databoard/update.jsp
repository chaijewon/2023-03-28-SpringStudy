<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
  width: 650px;
}
</style>
</head>
<body>
   <div class="row row1">
    <h1 class="text-center">수정</h1>
    <form method="post" action="../databoard/update_ok.do">
    <table class="table">
     <tr>
      <th width=15% class="text-right success">이름</th>
      <td width=85%>
       <input type=text name=name size=15 class="input-sm" value="${vo.name }">
       <input type="hidden" name=no value="${vo.no }">
      </td>
     </tr>
     <tr>
      <th width=15% class="text-right success">제목</th>
      <td width=85%><input type=text name=subject size=50 class="input-sm" value="${vo.subject }"></td>
     </tr>
     <tr>
      <th width=15% class="text-right success">내용</th>
      <td width=85%><textarea rows="10" cols="50" name="content">${vo.content }</textarea></td>
     </tr>
     <tr>
      <th width=15% class="text-right success">비밀번호</th>
      <td width=85%><input type=password name=pwd size=10 class="input-sm"></td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <button class="btn btn-sm btn-primary">수정</button>
         <input type=button value="취소" class="btn btn-sm btn-primary"
          onclick="javascript:history.back()">
       </td>
     </tr>
    </table>
    </form>
   </div>
</body>
</html>