<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table border="1" bordercolor="black" width=700 height=600>
    <tr>
      <td colspan="2" align=center height="100"><tiles:insertAttribute name="header"/></td>
    </tr>
    <tr>
      <td width=200 height="400"><tiles:insertAttribute name="menu"/></td>
      <td width=500 height="400" align=center><tiles:insertAttribute name="body"/></td>
    </tr>
    <tr>
      <td colspan="2" align=center height="100"><tiles:insertAttribute name="footer"/></td>
    </tr>
  </table>
</body>
</html>