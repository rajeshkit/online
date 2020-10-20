<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.loginform {
	align-content: center;
}
</style>
<title><spring:message code="label.titleLogin" /></title>
</head>
<body>
	<div
		style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		<a href="${pageContext.request.contextPath}/en/login">Login
			(English)</a> &nbsp;|&nbsp; <a
			href="${pageContext.request.contextPath}/fr/login">Login (French)</a>
		&nbsp;|&nbsp; <a href="${pageContext.request.contextPath}/hi/login">Login
			(Hindi)</a>
	</div>
	<form method="post" action="login">

		<table class="loginform" align="center">
			<tr>
				<th colspan="2"><font color="red">${errorMessage}</font></th>
			</tr>
			<tr>
				<td><strong> <spring:message code="label.userName" />
				</strong></td>
				<td><input type="text" name="username" required="required" /></td>
			</tr>
			<tr>
				<td><strong> <spring:message code="label.password" />
				</strong></td>
				<td><input type="password" name="password" required="required" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2" style="text-align: center;"><spring:message
						code="label.submit" var="labelSubmit"></spring:message> <input
					type="submit" value="${labelSubmit}" /></td>
			</tr>
		</table>
		<div>
			<span>
				<h2>
					Locale:
					<%=request.getSession().getAttribute("URL_LOCALE_ATTRIBUTE_NAME")%>
				</h2>
			</span>
		</div>
	</form>
</body>
</html>