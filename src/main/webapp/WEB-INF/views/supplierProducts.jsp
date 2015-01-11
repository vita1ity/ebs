<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<a href="<c:url value='/s/product/add'/>">Add Product</a>
	<c:forEach var="product" items="${products}" varStatus="loop">

		<p>${loop.index}.  ${product}</p>
		<a href="<c:url value='/s/product/delete/${product.productId}'/>">Delete Product</a>
		<a href="<c:url value='/s/product/edit/${product.productId}'/>">Edit Product</a>
	</c:forEach>
</body>
<%@ include file="footer.jsp" %>