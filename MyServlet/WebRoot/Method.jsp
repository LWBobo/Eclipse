<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <form action="req" method="get">
    	用户名: <input type="text" name="uname" value="" /><br />
    	密码: <input type="text" name="pwd" value="" /><br />
    	爱好：<br />
    	<input type="checkbox" name="fav" value="1"/>唱歌<br />
    	<input type="checkbox" name="fav" value="2"/>跳舞<br />
    	<input type="checkbox" name="fav" value="3"/>游泳<br />
    	
    	<input type="submit" value="登录" />
    	
    </form>
</body>
</html>