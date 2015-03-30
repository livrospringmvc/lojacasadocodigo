<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:page bodyClass="" title="">
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user"/>
		<spring:message code="users.welcome" arguments="${user.name}"/>
	</sec:authorize>
	
	<div>
		${success}
	</div>
	<ul class="menu">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${spring:mvcUrl('PC#form').build()}">Cadastrar novo produto</a></li>
		</sec:authorize>
	</ul>
	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td><a href="${spring:mvcUrl('PC#show').arg(0,product.id).build()}">${product.title}</a></td>
				<td>
					<c:forEach items="${product.prices}" var="price">
						[${price.value} - ${price.bookType}]
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</customTags:page>	
