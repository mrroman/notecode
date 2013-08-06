<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="path" required="true" type="java.lang.String" %>
<%@ attribute name="label" required="true" type="java.lang.String" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="control-group <s:bind path='${path}'><c:if test='${status.error}'>error</c:if></s:bind>">
	<f:label path="${path}">${label}:</f:label>
	<div class="controls">
		<jsp:doBody/>
		<f:errors cssClass="help-inline" path="${path}"/>	
	</div>
</div>