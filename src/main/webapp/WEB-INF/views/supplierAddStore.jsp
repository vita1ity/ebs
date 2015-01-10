<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ include file="supplierHeader.jsp" %>
<body>
	<p>New Store</p>
    <div>
    	<sf:form method="POST" modelAttribute="newStore" action="/ebs/s/store/add">
      		<p><sf:input path="contactNumbers" placeholder="contact numbers" required="false"/></p>
      		
      		<p><sf:input path="email" placeholder="email" required="false"/></p>
      		
      		<p>Store Location</p>
      		
      		<p><sf:input path="mall" placeholder="mall" required="true"/></p>
      		<p><sf:input path="place" placeholder="place" required="true"/></p>
      		<p><sf:input path="city" placeholder="city" required="true"/></p>
      		<p><sf:input path="country" placeholder="country" required="true"/></p>
      		
      		<p>Store Location</p>
      		<p><sf:input path="x" placeholder="x" required="true"/></p>
      		<p><sf:input path="y" placeholder="y" required="true"/></p>
     		
     		<font color='red'><sf:errors path="*"/></font>
     		
     		<p><button type="submit">Add Store</button></p>
     		<a href="<c:url value='/s/stores'/>">Back</a>
	        
     	</sf:form>
  	 </div>
</body>
<%@ include file="footer.jsp" %>