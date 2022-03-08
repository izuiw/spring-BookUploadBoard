<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h2>도서정보관리- 리스트</h2>
	<!--  <h3>전체 글 : ${count}</h3>-->
	<br>
	<br>

<!--  <form action="<c:url value='/search'/>">
		<input type="text" value="${ keyword}" name="keyword"
			placeholder="도서제목 또는 저자 입력" /> <input type="submit" value="검색하기" />
	</form>-->	
	<form action="<c:url value='/search'/>" name="listCommand">
		<select name = 'option'>
			<option value="writer"><spring:message code="writer" /></option>
			<option value="name"><spring:message code="name" /></option>
			<option value="publisher"><spring:message code="publisher"/></option>
		</select>
		<input name="keyword" type="text" value="${ keyword}"  placeholder="도서제목 또는 저자 입력" />
		<input type="submit" value="검색하기" />
	</form>
	

	<table border="1">
		<tr>
			<th><spring:message code="num" /></th>
			<th><spring:message code="image" /></th>
			<th><spring:message code="isbn" /></th>
			<th><spring:message code="name" /></th>
			<th><spring:message code="writer" /></th>
			<th><spring:message code="publisher" /></th>
			<th><spring:message code="price" /></th>
		</tr>
		<c:if test="${ count == 0}">
			<tr>
				<td colspan="7">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</c:if>

		<c:if test="${ count > 0}">
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.num }</td>
					<td width="10px"><img
						src="<spring:url value='/resources/upload/${list.image}'/>" /></td>
					<td>${list.isbn }</td>
					<td><a href="<c:url value='/read/${list.num }'/>">${list.name }</a></td>

					<td>${list.writer }</td>
					<td>${list.publisher }</td>
					<td>${list.price }</td>
				</tr>

			</c:forEach>

		</c:if>


		<c:if test="${searchCount == 0 }">
			<tr>
				<td colspan="7">해당 항목이 없습니다.</td>
			</tr>
		</c:if>

		<c:if test="${searchCount > 0 }">
			<c:forEach var="searchList" items="${searchList}">
				<tr>
					<td>${searchList.num }</td>
					<td width="10px"><img
						src="<spring:url value='/resources/upload/${searchList.image}'/>" /></td>
					<td>${searchList.isbn }</td>
					<td><a href="<c:url value='/read/${searchList.num }'/>">${searchList.name }</a></td>

					<td>${searchList.writer }</td>
					<td>${searchList.publisher }</td>
					<td>${searchList.price }</td>
				</tr>

			</c:forEach>

		</c:if>



	</table>
	<input type="button" value="<spring:message code="insert.add"/>" 
		onclick="window:location='<c:url value='/add'/>'"/>
	<input type="button" value="<spring:message code="main.go"/>"
		onclick="window:location='<c:url value='/main'/>'" />
</body>
</html>