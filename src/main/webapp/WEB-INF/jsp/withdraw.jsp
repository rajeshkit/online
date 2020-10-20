<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
<title><spring:message code="label.titleWithdraw" /></title>
</head>
<body>
	<div
		style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		<a href="${pageContext.request.contextPath}/en/login"><spring:message
				code="label.home" /></a>
	</div>
	<div id="container">
		<div id="content">
			<h1 class="title">
				<spring:message code="label.titleWithdraw" />
			</h1>
			<table>
				<f:form action="checkWithdraw" modelAttribute="accountDetails">
					<tr>
						<td><f:label path="accountNumber">
								<spring:message code="label.accountNumber" />
							</f:label></td>
						<td><f:input type="text" path="accountNumber"
								id="accountNumber" value="${accountDetails.accountNumber}" /></td>
						<td><f:errors path="accountNumber" cssClass="error" /></td>
					</tr>
					<tr>
						<td><f:label path="username">
								<spring:message code="label.userName" />
							</f:label></td>
						<td><f:input type="text" path="username" id="username"
								readonly="readonly" value="${accountDetails.username}" /></td>
						<td><f:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label><spring:message code="label.amount" /></label></td>
						<td><input type="number" name="amount" min="0"
							required="required" /></td>
						<td><f:errors cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><button>
								<spring:message code="label.withdraw" />
							</button></td>
					</tr>
				</f:form>
			</table>
			<h1>${msg}</h1>
		</div>
	</div>
</body>
</html>