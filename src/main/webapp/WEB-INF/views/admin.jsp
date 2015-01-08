<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
	<div class="login-form">
	    <p>New User</p>
	    <div>
	    	<sf:form class="form-wrapper-01" method="POST" modelAttribute="newUser" action="/project/admin">
	      		<sf:input class="inputbox email" path="username" id="username" placeholder="username" required="true"/>
	      		<br>
	      		<sf:select path="role" items="${roleList}"></sf:select>
	      		<br>
	      		<sf:password class="inputbox password" path="password" showPassword="true" id="user_password" placeholder="password" required="true"/>
	      		<br>
	      		<sf:password class="inputbox password" path="confirmPassword" showPassword="true" id="confirm_password" placeholder="confirm password" required="true"/>
	     		<br>
	     		<font color='red'><sf:errors path="*"/></font>
	     		
		        <hr /><p><button class="btn btn-blue" type="submit" class="button">Register <i class="icon-paper-plane"></i></button></p>
		        
	     	</sf:form>
	  	 </div>
	  	 
	  	 <a class="btn btn-blue" href="<c:url value='/logout'/>">Logout</a>

	</div>
</body>
</html>