<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<header>
	<a href="<c:url value='/s/profile'/>">Profile</a>
	<a href="<c:url value='/s/products'/>">Products</a>
	<a href="<c:url value='/s/stores'/>">Stores</a>
	<a href="<c:url value='/s/transactions'/>">Transactions History</a>
	<a href="<c:url value='/s/settings'/>">Settings</a>
	
	<a class="btn btn-blue" href="<c:url value='/logout'/>">Logout</a>
</header>