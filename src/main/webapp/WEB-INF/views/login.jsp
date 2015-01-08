<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
    </head>
    <body>
        <div class="login-form">
		    <p>Login</p>
		    
		    <div>
		    	<c:url value="/j_spring_security_check" var="loginUrl" />
			    <form class="form-wrapper-01" action="${loginUrl}" method="POST"> 
			        <input type="text" class="inputbox email" id="j_username" name="j_username" placeholder="username" required autofocus>
			        <br>
			        <input type="password" class="inputbox password" id="j_password" name="j_password" placeholder="password" required>
			        <br>
			        <c:if test="${param.error == 'true'}">
 								<font color='red'><span>Your login attempt was not successful, try again.<br /> 
						Reason: Invalid username or password</span></font>
					</c:if>
			        <hr /><p><button class="btn btn-blue" type="submit">Login</button></p>
			    </form>
		    	
		    </div>
		    <hr/>
 
 		</div>
    </body>
</html>
