<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "hello.HelloClient" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=utf-8">
<title>Thrift Web Application</title>
</head>
<body>
<form action="ThriftClient" method="get">
서버주소 : <input type="text" name="serverIP"/><br/>
서버포트 : <input type="text" name="serverPort"><br/>
이름 : <input type="text" name="name"><br/>
나이 : <input type="text" name="age"><br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>