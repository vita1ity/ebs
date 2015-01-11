<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<p>New Product</p>
    <div>
    	<sf:form method="POST" commandName="newProduct">
      		<p><sf:input path="productName" placeholder="product name" required="true"/></p>
      		
      		<p><sf:input path="description" placeholder="description" required="false"/></p>
      		
      		<p>Is product valid ? <sf:checkbox path="validity" /></p>
      		
      		<p>Choose the Stores where product available:</p>
            <p><sf:checkboxes path="stringStores" items="${newProduct.stringStores}" /></p>
     		
     		<font color='red'><sf:errors path="*"/></font>
     		
     		<p><button type="submit">Add Product</button></p>
     		<a href="<c:url value='/s/products'/>">Back</a>
	        
	        
     	</sf:form>
  	 </div>
</body>
<%@ include file="footer.jsp" %>