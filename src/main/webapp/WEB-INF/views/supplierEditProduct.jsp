<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<p>Edit Product</p>
    <div>
    	<sf:form method="POST" commandName="product">
      		<p><sf:input path="productName" placeholder="${product.productName}" required="true"/></p>
      		
      		<p><sf:input path="description" placeholder="${product.description}" required="false"/></p>
      		
      		<p>Is product valid ? <sf:checkbox path="validity" placeholder="${product.validity}"/></p>
      		
      		<p>Choose the Stores where product available:</p>
            <p><sf:checkboxes path="stringStores" items="${stringStores}" /></p>
     		
     		<font color='red'><sf:errors path="*"/></font>
     		
     		<p><button type="submit">Edit Product</button></p>
     		<a href="<c:url value='/s/products'/>">Back</a>
	        
	        
     	</sf:form>
  	 </div>
</body>
<%@ include file="footer.jsp" %>