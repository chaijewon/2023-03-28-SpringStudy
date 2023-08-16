<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form method=post action="../test/add.do">
  <div>
   이름:<input type=text name=list[0].name size=10><br>
   성별:<input type=text name=list[0].sex size=10><br>
   나이:<input type=text name=list[0].age size=10><br>
  </div>
  <div>
   이름:<input type=text name=list[1].name size=10><br>
   성별:<input type=text name=list[1].sex size=10><br>
   나이:<input type=text name=list[1].age size=10><br>
  </div>
  <div>
  이름:<input type=text name=list[2].name size=10><br>
   성별:<input type=text name=list[2].sex size=10><br>
   나이:<input type=text name=list[2].age size=10><br>
  </div>
  <button>전송</button>
  </form>
</body>
</html>