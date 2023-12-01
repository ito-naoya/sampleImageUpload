<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String filename = (String)request.getAttribute("filename");
%>

<img src="./images/<%= filename %>" alt="なにかしらの画像">

</body>
</html>