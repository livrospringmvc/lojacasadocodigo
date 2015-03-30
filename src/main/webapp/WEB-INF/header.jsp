	<header id="layout-header">
		<div class="clearfix container">
			<a href="/" id="logo"> 
			</a>
			<div id="header-content">
				<nav id="main-nav">
					<ul class="clearfix">

						<li><a href="${spring:mvcUrl('SCC#items').build()}" rel="nofollow">Seu carrinho (${shoppingCart.quantity}) </a></li>

						<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre
								nós </a></li>

						<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas
								Frequentes </a></li>

					</ul>
				</nav>
			</div>
		</div>
	</header>
	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="http://www.casadocodigo.com.br">Home</a>
			<li class="category"><a href="/collections/livros-de-agile">
					Agile </a>
			<li class="category"><a href="/collections/livros-de-front-end">
					Front End </a>
			<li class="category"><a href="/collections/livros-de-games">
					Games </a>
			<li class="category"><a href="/collections/livros-de-java">
					Java </a>
			<li class="category"><a href="/collections/livros-de-mobile">
					Mobile </a>
			<li class="category"><a
				href="/collections/livros-desenvolvimento-web"> Web </a>
			<li class="category"><a href="/collections/outros"> Outros </a>
		</ul>
	</nav>