<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/casadocodigo/produtos" method="post">
		<div>
			<label for="titulo">Titulo</label>
			<input type="text" name="titulo" id="titulo"/>
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao" id="descricao"></textarea>
		</div>
		<div>
			<label for="numeroPaginas">Número de paginas</label>
			<input type="text" name="numeroPaginas" id="numeroPaginas"/>
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
	</form>

</body>
</html>