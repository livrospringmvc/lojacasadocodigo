<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		${sucesso}
	</div>
	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td><a href="/casadocodigo/produtos/${produto.id}">${produto.titulo}</a></td>
				<td>
					<c:forEach items="${produto.valores}" var="valorTipo">
						[${valorTipo.valor} - ${valorTipo.tipoLivro}]
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>