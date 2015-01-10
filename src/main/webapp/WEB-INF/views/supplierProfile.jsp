<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<p><sec:authentication property='principal.userId'/></p>
	<p><sec:authentication property='principal.username'/></p>
</body>
<%@ include file="footer.jsp" %>