<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="hero-unit">
	${name} ${age} ${inMillis}
	<form action="hello" method="POST">
		<input type="text" name="name">
		<input type="text" name="age">
		<input type="date" name="date">
		<button type="submit" class="btn">Send</button>
	</form>
</div>