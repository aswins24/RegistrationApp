<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="sc" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LogIn</h1>
	
	<sp:form action="login" modelAttribute="log">
		
		Enter email: <sp:input path="email"/><sp:errors path="email"/><br/>
		Enter password: <sp:password path="pass"/><sp:errors path="pass"/><br/>
		
		
		<br/>
		
		<input type="submit" value="LogIn"/>
		
	</sp:form>
	${errormsg}

</body>
</html>