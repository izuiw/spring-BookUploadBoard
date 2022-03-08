<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	text-align: center;
}

table {
	margin: auto;
	width: 70%;
}
</style>
<title><spring:message code="books.title" /></title>
</head>
<body>
	<h2>도서정보관리-도서정보</h2>

	<table border="1">

		<tr>
			<td rowspan="6" width="30%"><img
				src="<spring:url value='/resources/upload/${list.image}'/>" /></td>
		</tr>
		<tr>
			<td><spring:message code="isbn" /></td>
			<td>${list.isbn }</td>

		</tr>
		<tr>
			<td><spring:message code="name" /></td>
			<td>${list.name }</td>

		</tr>
		<tr>
			<td><spring:message code="writer" /></td>
			<td>${list.writer }</td>
		</tr>
		<tr>
			<td><spring:message code="publisher" /></td>
			<td>${list.publisher }</td>
		</tr>

		<tr>
			<td><spring:message code="price" /></td>
			<td>${list.price }</td>
		</tr>

		<tr>
			<td><spring:message code="content" /></td>
			<td colspan="2">${list.content }</td>
		</tr>

	</table>
	<input type="button" value="<spring:message code="insert.list"/>"
		onclick="window:location='<c:url value='/list'/>'" />

</body>
</html>