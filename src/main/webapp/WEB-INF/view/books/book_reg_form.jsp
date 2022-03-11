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
<script>
function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      document.getElementById('preview').src = e.target.result;
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('preview').src = "";
	  }
	}
</script>

<title><spring:message code="books.title" /></title>
</head>
<body>

	<h2>도서정보관리-도서추가</h2>
	<form:form commandName="formData" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th colspan="3">*표시는 필수입니다.</th>
			</tr>

			<tr>
				<td rowspan="7" width="30%"><img id="preview"> 

 				</td>
			</tr>


			<tr>
				<td>*<spring:message code="isbn" /></td>
				<td><form:input path="isbn" placeholder="8자리 숫자 입력" /> <form:errors
						path="isbn" /></td>

			</tr>
			<tr>
				<td>*<spring:message code="name" /></td>
				<td><form:input path="name" /> <form:errors path="name" /></td>

			</tr>
			<tr>
				<td>*<spring:message code="writer" /></td>
				<td><form:input path="writer" /> <form:errors path="writer" /></td>

			</tr>
			<tr>
				<td>*<spring:message code="publisher" /></td>
				<td><form:input path="publisher" /> <form:errors
						path="publisher" /></td>

			</tr>
			<tr>
				<td>*<spring:message code="price" /></td>
				<td><form:input path="price" pattern="[0-9]+" placeholder="숫자 입력" /> <form:errors path="price" /></td>

			</tr>
			<tr>
				<td>*<spring:message code="image" /></td>
				<td><form:input path="image" type="file" onchange="readURL(this);" accept="image/*"/> <form:errors
						path="image" /></td>

			</tr>

			<tr>
				<td height="250px"><spring:message code="content" /></td>
				<td colspan="2"><form:textarea path="content" /> <form:errors
						path="content" /></td>
			</tr>


		</table>
		<input type="submit" value="<spring:message code="insert.add"/>" />
		<input type="button" value="<spring:message code="insert.list"/>"
			onclick="window:location='<c:url value='/list'/>'" />
	</form:form>

</body>
</html>