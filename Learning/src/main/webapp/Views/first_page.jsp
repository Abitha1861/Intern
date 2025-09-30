<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
First page
    <a href="<%= request.getContextPath() %>/second_page">
        <button type="button">Go to Second Page</button>
    </a>
</body>
</html>