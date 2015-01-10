<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<a href="<c:url value='/s/store/add'/>">Add Store</a>
	<c:forEach var="store" items="${stores}" varStatus="loop">

		<p>${loop.index}.  ${store}</p>
		<a href="<c:url value='/s/store/delete/${store.storeId}'/>">Delete Store</a>
		<a href="<c:url value='/s/store/edit/${store.storeId}'/>">Edit Store</a>
	</c:forEach>
</body>
<%@ include file="footer.jsp" %>