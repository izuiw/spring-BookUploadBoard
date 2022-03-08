<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	text-align: center;
}

table {
	margin: auto;
	width: 70%;
}
</style>
<meta charset="UTF-8">
<title><spring:message code="books.title" /></title>
</head>
<body>
<br><br>
	<a href="<c:url value='/list'/>">[<spring:message code="insert.list"/>]</a>
	<a href="<c:url value='/add'/>">[<spring:message code="insert.add"/>]</a>

</body>
</html>