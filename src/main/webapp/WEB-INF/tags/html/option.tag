<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="option" required="true" type="com.cgi.skills.beans.Option"%>
<%@ attribute name="id" required="true" type="java.lang.Object"%>

<c:choose>
	<c:when test="${id eq option.id}">
		<option value="${option.id}" selected="selected">${option.name}</option>
	</c:when>
	<c:otherwise>
		<option value="${option.id}">${option.name}</option>
	</c:otherwise>
</c:choose>