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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0;
$(function(){
	$('#addBtn').click(function(){
		$('#user-table > tbody').append(
		  '<tr id="m'+(fileIndex)+'">'
		 +'<td>첨부파일 '+(fileIndex+1)+'<input type=file size=20 name=files['+fileIndex+']>'
		 +'</td>'
		 +'</tr>'
		)
		fileIndex++;
	})
	$('#removeBtn').click(function(){
		if(fileIndex>0)
		{
		   $('#m'+(fileIndex-1)).remove();
		   fileIndex--;
		}
	})
})
</script>
</head>
<body>
   <div class="row row1">
    <h1 class="text-center">글쓰기</h1>
    <form method="post" action="../databoard/insert_ok.do"
     enctype="multipart/form-data"
    >
    <table class="table">
     <tr>
      <th width=15% class="text-right success">이름</th>
      <td width=85%><input type=text name=name size=15 class="input-sm"></td>
     </tr>
     <tr>
      <th width=15% class="text-right success">제목</th>
      <td width=85%><input type=text name=subject size=50 class="input-sm"></td>
     </tr>
     <tr>
      <th width=15% class="text-right success">내용</th>
      <td width=85%><textarea rows="10" cols="50" name="content"></textarea></td>
     </tr>
     <tr>
       <th width=15% class="text-right success">첨부파일</th>
       <td width=85%>
         <table class="table">
          <tr>
           <td class="text-right">
            <input type="button" value="추가" 
              class="btn btn-xs btn-info" id="addBtn">
            <input type="button" value="취소" id="removeBtn"
              class="btn btn-xs btn-warning" 
            >
           </td>
          </tr>
         </table>
         <table class="table" id="user-table">
           <tbody>
            
           </tbody>
         </table>
       </td>
     </tr>
     <tr>
      <th width=15% class="text-right success">비밀번호</th>
      <td width=85%><input type=password name=pwd size=10 class="input-sm"></td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <button class="btn btn-sm btn-primary">글쓰기</button>
         <input type=button value="취소" class="btn btn-sm btn-primary"
          onclick="javascript:history.back()">
       </td>
     </tr>
    </table>
    </form>
   </div>
</body>
</html>