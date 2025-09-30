<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
second page
    <a href="<%= request.getContextPath() %>/">
        <button type="button">Go to first Page</button>
    </a>
</body>
</html>