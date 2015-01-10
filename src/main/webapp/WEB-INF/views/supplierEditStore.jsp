<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<p>New Store</p>
    <div>
    	<sf:form method="POST" modelAttribute="store" action="/ebs/s/store/edit/${store.storeId}">
      		<p><sf:input path="contactNumbers" placeholder="${store.contactNumbers}" required="false"/></p>
      		
      		<p><sf:input path="email" placeholder="${store.email}" required="false"/></p>
      		
      		<p>Store Location</p>
      		
      		<p><sf:input path="mall" placeholder="${store.mall}" required="true"/></p>
      		<p><sf:input path="place" placeholder="${store.place}" required="true"/></p>
      		<p><sf:input path="city" placeholder="${store.city}" required="true"/></p>
      		<p><sf:input path="country" placeholder="${store.country}" required="true"/></p>
      		
      		<p>Store Location</p>
      		<p><sf:input path="x" placeholder="${store.x}" required="true"/></p>
      		<p><sf:input path="y" placeholder="${store.y}" required="true"/></p>
     		
     		<font color='red'><sf:errors path="*"/></font>
     		
     		<p><button type="submit">Edit Store</button></p>
     		<a href="<c:url value='/s/stores'/>">Back</a>
	        
     	</sf:form>
  	 </div>
</body>
<%@ include file="footer.jsp" %>