<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<fmt:message key="shoppingCart.title" var="title" />
<customTags:page bodyClass="cart" title="${title}">
<jsp:attribute name="extraScripts">
<script>
	$(function() {
		$('#checkout').click(function() {
			_gaq.push([ '_trackPageview', '/checkout/finalizaCompra' ]);
		});

		$('.book-suggest').click(function() {
			var book = $(this).data('book');
			_gaq.push([ '_trackEvent', 'Recomendação', 'Livro', book ]);
		});
	});
</script>

<noscript>
	<img height="1" width="1" alt="" style="display: none"
				src="https://www.facebook.com/offsite_event.php?id=6009930053200&amp;value=0&amp;currency=USD" />
</noscript>

<script>
	$(function() {
		$('a[href^="http"]').not('.dont-track').filter(function(index) {
			var ccb = $(this).attr('href').indexOf("casadocodigo.com.br");
			if (ccb == -1)
				ccb = $(this).attr('href').indexOf("localhost");

			return ccb != 7 && ccb != 11;
		}).click(function(event) {
			var domain = this.href;
			domain = domain.substring(7);
			domain = domain.substring(0, domain.indexOf('/'));

			if (domain.substring(0, 4) == 'www.')
				domain = domain.substring(4);

			_gaq.push([ '_trackPageview', '/LinkExterno/' + this.href ]);
		});
	});
</script>
</jsp:attribute>
<jsp:body>
	<section class="container middle">
		<h2 id="cart-title">Seu carrinho de compras</h2>
		<table id="cart-table">
			<colgroup>
				<col class="item-col">
				<col class="item-price-col">
				<col class="item-quantity-col">
				<col class="line-price-col">
				<col class="delete-col">
			</colgroup>
			<thead>
				<tr>
					<th class="cart-img-col"></th>
					<th width="65%">Item</th>
					<th width="10%">Preço</th>
					<th width="10%">Quantidade</th>
					<th width="10%">Total</th>
					<th width="5%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shoppingCart.list}" var="item">
					<tr>
						<td class="cart-img-col"><img src=""
							alt="${item.product.title}" /></td>
						<td class="item-title">${item.product.title}-
							${item.bookType}</td>
						<td class="numeric-cell">${item.price}</td>
						<td class="quantity-input-cell"><input type="number" min="0"
							readonly="readonly" value="${shoppingCart.getQuantity(item)}"></td>
						<td class="numeric-cell">${shoppingCart.getTotal(item)}</td>
						<td class="remove-item"><form:form method="post"
								action="${spring:mvcUrl('SCC#remove').arg(0,item.product.id).arg(1,item.bookType).build()}">
								<input type="image"
									src="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/excluir.png?58522"
									alt="Excluir" title="Excluir" />
							</form:form></td>
					</tr>
				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><form:form
							action="${spring:mvcUrl('PC#checkout').build()}" method="post">
							<input type="submit" class="checkout" name="checkout"
								value="Finalizar compra " id="checkout" />
						</form:form></td>
					<td class="numeric-cell">${shoppingCart.total}</td>
					<td></td>
				</tr>
			</tfoot>
		</table>

		<h2>Você já conhece os outros livros da Casa do Código?</h2>
		<ul id="collection" class="related-books">
			<li class="col-left"><a href="/products/livro-mean"
				class="block clearfix book-suggest"
				data-book="Mean: Full stack JavaScript para aplicações web com MongoDB, Express, Angular e Node">
					<img width="113px" height="160px"
					src="//cdn.shopify.com/s/files/1/0155/7645/products/cover_compact.jpeg?v=1421258660"
					alt="Mean: Full stack JavaScript para aplicações web com MongoDB, Express, Angular e Node">
			</a></li>
			<li class="col-right"><a
				href="/products/livro-certificacao-java-associate"
				class="block clearfix book-suggest"
				data-book="Java SE 7 Programmer I: O guia para sua certificação Oracle Certified Associate">
					<img width="113px" height="160px"
					src="//cdn.shopify.com/s/files/1/0155/7645/products/certificacao-java-associate-featured_compact.png?v=1415277209"
					alt="Java SE 7 Programmer I: O guia para sua certificação Oracle Certified Associate">
			</a></li>
			<li class="col-left"><a href="/products/livro-sql-oracle"
				class="block clearfix book-suggest"
				data-book="SQL: Uma abordagem para bancos de dados Oracle"> <img
					width="113px" height="160px"
					src="//cdn.shopify.com/s/files/1/0155/7645/products/Amazon-SQL-Oracle_compact.jpg?v=1416425806"
					alt="SQL: Uma abordagem para bancos de dados Oracle">
			</a></li>
			<li class="col-right"><a
				href="/products/livro-orientacao-objetos-java"
				class="block clearfix book-suggest"
				data-book="Desbravando Java e Orientação a Objetos: Um guia para o iniciante da linguagem">
					<img width="113px" height="160px"
					src="//cdn.shopify.com/s/files/1/0155/7645/products/orientacao-objetos-java-featured_compact.png?v=1416402140"
					alt="Desbravando Java e Orientação a Objetos: Um guia para o iniciante da linguagem">
			</a></li>
			<li class="col-left"><a href="/products/livro-android"
				class="block clearfix book-suggest"
				data-book="Google Android: crie aplicações para celulares e tablets">
					<img width="113px" height="160px"
					src="//cdn.shopify.com/s/files/1/0155/7645/products/android-featured_compact.png?v=1411489561"
					alt="Google Android: crie aplicações para celulares e tablets">
			</a></li>
		</ul>

		<h2>
			<a href="http://www.casadocodigo.com.br">Veja todos os livros que
				publicamos!</a>
		</h2>
	</section>
</jsp:body>	
</customTags:page>