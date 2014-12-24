<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.casadocodigo.com.br/tags/form" prefix="customForm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<spring:hasBindErrors name="produto">
		<ul>
		<c:forEach var="error" items="${errors.allErrors}">	
			<li>${error.code}-${error.field}</li>
		</c:forEach>
		</ul>
	</spring:hasBindErrors>
	<form:form action="/casadocodigo/produtos" method="post" commandName="produto">
		<div>
			<label for="titulo">Titulo</label>
			<form:input path="titulo"/>
			<form:errors path="titulo"/>
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao" id="descricao"></textarea>
		</div>
		<div>
			<label for="numeroPaginas">Número de paginas</label>
			<input type="text" name="numeroPaginas" id="numeroPaginas"/>
			<form:errors path="numeroPaginas"/>
		</div>
		<div>
			<label for="releaseDate">Data de lançamento</label>			
			<customForm:date path="releaseDate"/>
			<form:errors path="releaseDate"/>
		</div>		
		<div>
			<c:forEach items="${tiposLivro}" var="tipoLivro" varStatus="status">
				<div>
					<label for="preco_${tipoLivro}">${tipoLivro}</label>
					<input type="text" name="valores[${status.index}].valor" id="preco_${tipoLivro}"/>
					<input type="hidden" name="valores[${status.index}].tipoLivro" value="${tipoLivro}"/>
				</div>
			</c:forEach>
		</div>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form:form>

</body>
</html>