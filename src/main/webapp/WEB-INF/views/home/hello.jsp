<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="hero-unit">
	<div>
		${daysBetween.daysBetween}
	</div>
	<f:form commandName="daysBetween" method="POST">
		<t:field label="From" path="from">
			<f:input path="from" type="date"/>
		</t:field>
		<t:field label="To" path="to">
			<f:input path="to" type="date"/>
		</t:field>
		<button type="submit" class="btn">Send</button>
	</f:form>
</div>