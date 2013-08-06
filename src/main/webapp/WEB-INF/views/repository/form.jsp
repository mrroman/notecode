<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="hero-unit">
	<f:form modelAttribute="repository" method="POST">
		<t:field label="Name" path="name">
			<f:input path="name"/>
		</t:field>
		<t:field label="Address" path="address">
			<f:input path="address"/>
		</t:field>
		<t:field label="Care Email" path="careEmail">
			<f:input path="careEmail" type="email"/>
		</t:field>
		<button type="submit" class="btn">Send</button>
	</f:form>
</div>