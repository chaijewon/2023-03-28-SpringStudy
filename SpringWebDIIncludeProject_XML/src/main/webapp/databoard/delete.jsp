<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
  width: 350px;
}
</style>
</head>
<body>
   <div class="row row1">
     <h3 class="text-center">삭제하기</h3>
     <form method="post" action="../databoard/delete_ok.do">
     <table class="table">
       <tr>
        <td class="text-center">
        비밀번호:<input type=password name=pwd size=20>
        <input type="hidden" name="no" value="${no}">
        </td>
       </tr>
       <tr>
         <td class="text-center">
          <button class="btn btn-sm btn-danger">삭제</button>
          <input type=button value="취소" class="btn btn-sm btn-primary"
          onclick="javascript:history.back()">
         </td>
       </tr>
     </table>
     </form>
   </div>
</body>
</html>



