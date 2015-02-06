<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		${success}
	</div>
	${shoppingCart}
	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
			<td>Carrinho</td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td><a href="/casadocodigo/produtos/${product.id}">${product.title}</a></td>
				<td>
					<c:forEach items="${product.prices}" var="price">
						[${price.value} - ${price.bookType}]
					</c:forEach>
				</td>
				<td>
					<form action="${spring:mvcUrl('SCC#add').arg(0,product.id).build()}" method="post">
						<input type="submit" value="Adicionar">
					</form>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>