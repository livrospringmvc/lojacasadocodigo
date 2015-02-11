<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body class="cart">

  <header id="layout-header">
    <div class="clearfix container">
        <a href="/" id="logo">
          <!-- <img src="http://cdn.shopify.com/s/files/1/0155/7645/t/177/assets/casa-do-codigo-blue.svg?58522" alt="Casa do Codigo"> -->
        </a>
      <div id="header-content">
        <nav id="main-nav">
              <ul class="clearfix">
                
                  <li>
                    
                      <a href="${spring:mvcUrl('SCC#items').build()}" rel="nofollow">Seu carrinho(${shoppingCart.quantity})                    
                      </a>
                    </li>
                
                  <li>
                    
                      <a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre nós
                    
                      </a>
                    </li>
                
                  <li>
                    
                      <a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes
                    
                      </a>
                    </li>
                
              </ul>
        </nav>
      </div>
    </div>
  </header>
  <nav class="categories-nav">
    <ul class="container">
        <li class="category"><a href="http://www.casadocodigo.com.br">Home</a>
        
            
                <li class="category"><a href="/collections/livros-de-agile">
                    Agile
                  </a>
            
        
            
                <li class="category"><a href="/collections/livros-de-front-end">
                    Front End
                  </a>
            
        
            
        
            
        
            
                <li class="category"><a href="/collections/livros-de-games">
                    Games
                  </a>
            
        
            
                <li class="category"><a href="/collections/livros-de-java">
                    Java
                  </a>
            
        
            
                <li class="category"><a href="/collections/livros-de-mobile">
                    Mobile
                  </a>
            
        
            
                <li class="category"><a href="/collections/livros-desenvolvimento-web">
                    Web
                  </a>
            
        
            
                <li class="category"><a href="/collections/outros">
                    Outros
                  </a>
            
        
    </ul>
  </nav>

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
          <td class="cart-img-col"><img src="" alt="${item.product.title}"/></td><td class="item-title">${item.product.title} - ${item.bookType}</td>
          <td class="numeric-cell">${item.price}</td>
          <td class="quantity-input-cell"><input type="number" min="0" readonly="readonly" value="${shoppingCart.getQuantity(item)}"></td>
          <td class="numeric-cell">${shoppingCart.getTotal(item)}</td>
          <td class="remove-item"><form method="post" action="${spring:mvcUrl('SCC#remove').arg(0,item.product.id).arg(1,item.bookType).build()}"><input type="image" src="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/excluir.png?58522" alt="Excluir" title="Excluir" /></form></td>
        </tr>
        </c:forEach>
        
      </tbody>
      <tfoot>
        <tr>
          <td colspan="2">
          	<form action="${spring:mvcUrl('PC#checkout').build()}" method="post">
          		<input type="submit" class="checkout" name="checkout" value="Finalizar compra " id="checkout"/>
          	</form>
          </td>
          <td class="numeric-cell">${shoppingCart.total}</td><td></td>
        </tr>
      </tfoot>
    </table>
    
  
 
  
  <h2>Você já conhece os outros livros da Casa do Código?</h2>
  <ul id="collection" class="related-books">
      
     
        
        

        
        
        
        
        
          
        

      
     
        
        

        
        
        
        
        
          
            <li class="col-left">
              <a href="/products/livro-mean" class="block clearfix book-suggest" data-book="Mean: Full stack JavaScript para aplicações web com MongoDB, Express, Angular e Node">
                <img width="113px" height="160px" src="//cdn.shopify.com/s/files/1/0155/7645/products/cover_compact.jpeg?v=1421258660" alt="Mean: Full stack JavaScript para aplicações web com MongoDB, Express, Angular e Node">
              </a>
            </li>
          
        

      
     
        
        

        
        
        
        
        
          
        

      
     
        
        

        
        
        
        
        
          
            <li class="col-right">
              <a href="/products/livro-certificacao-java-associate" class="block clearfix book-suggest" data-book="Java SE 7 Programmer I: O guia para sua certificação Oracle Certified Associate">
                <img width="113px" height="160px" src="//cdn.shopify.com/s/files/1/0155/7645/products/certificacao-java-associate-featured_compact.png?v=1415277209" alt="Java SE 7 Programmer I: O guia para sua certificação Oracle Certified Associate">
              </a>
            </li>
          
        

      
     
        
        

        
        
        
        
        
          
            <li class="col-left">
              <a href="/products/livro-sql-oracle" class="block clearfix book-suggest" data-book="SQL: Uma abordagem para bancos de dados Oracle">
                <img width="113px" height="160px" src="//cdn.shopify.com/s/files/1/0155/7645/products/Amazon-SQL-Oracle_compact.jpg?v=1416425806" alt="SQL: Uma abordagem para bancos de dados Oracle">
              </a>
            </li>
          
        

      
     
        
        

        
        
        
        
        
          
            <li class="col-right">
              <a href="/products/livro-orientacao-objetos-java" class="block clearfix book-suggest" data-book="Desbravando Java e Orientação a Objetos: Um guia para o iniciante da linguagem">
                <img width="113px" height="160px" src="//cdn.shopify.com/s/files/1/0155/7645/products/orientacao-objetos-java-featured_compact.png?v=1416402140" alt="Desbravando Java e Orientação a Objetos: Um guia para o iniciante da linguagem">
              </a>
            </li>
          
        

      
     
        
        

        
        
        
        
        
          
            <li class="col-left">
              <a href="/products/livro-android" class="block clearfix book-suggest" data-book="Google Android: crie aplicações para celulares e tablets">
                <img width="113px" height="160px" src="//cdn.shopify.com/s/files/1/0155/7645/products/android-featured_compact.png?v=1411489561" alt="Google Android: crie aplicações para celulares e tablets">
              </a>
            </li>
          
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
     
        
        

        
        
        
        
        

      
  </ul>
  
  <h2><a href="http://www.casadocodigo.com.br">Veja todos os livros que publicamos!</a></h2>
  
  


</section> 


  <footer id="layout-footer">
    <div class="clearfix container">
        

        
 
      <div id="collections-footer"><!-- cdc-footer -->
        <p class="footer-title">Coleções de Programação</p>
        <ul class="footer-text-links">
          <li><a href="/collections/livros-de-java">Java</a></li>
          <li><a href="/collections/livros-desenvolvimento-web">Desenvolvimento Web</a></li>
          <li><a href="/collections/livros-de-mobile">Mobile</a></li>
          <li><a href="/collections/games">Games</a></li>
          <li><a href="/collections/livros-de-front-end">Front End</a></li>
        </ul>
        <p class="footer-title">Outros Assuntos</p>
        <ul class="footer-text-links">
          <li><a href="/collections/livros-de-agile">Agile</a></li>
          <li><a href="/collections/outros">e outros...</a></li>
        </ul>
      </div>
      <div id="social-footer"><!-- books-footer -->
         <p class="footer-title">Links da Casa do Código</p>
         <ul class="footer-text-links">
          <li><a href="http://livros.casadocodigo.com.br" rel="nofollow">Meus E-books</a></li>
          <li><a href="/pages/sobre-a-casa-do-codigo">Sobre a Casa do Código</a></li>
          <li><a href="/pages/perguntas-frequentes">Perguntas Frequentes</a></li>
          <li><a href="https://www.caelum.com.br">Caelum - Ensino e Inovação</a></li>
          <li><a href="http://www.codecrushing.com/" rel="nofollow">Code Crushing</a></li>
         </ul>
         <p class="footer-title">Redes Sociais</p>
         <ul>
          <li class="social-links">
            <a href="http://www.twitter.com/casadocodigo" target="_blank" id="twitter" rel="nofollow">Facebook</a>
            <a href="http://www.facebook.com/casadocodigo" target="_blank" id="facebook" rel="nofollow">Twitter</a>
          </li>
        </ul>
      </div>
      <div id="newsletter-footer"><!-- social-footer -->
        <p class="footer-title">Receba as Novidades e Lançamentos</p>
        <div id="form-newsletter">                  
          <form action="https://docs.google.com/spreadsheet/formResponse?formkey=dFhxZ2tDalFiclU4T2FLZVY4UXVUc2c6MQ&embedded=true&ifq" method="POST" id="ss-form" class="form-newsletter">
            <ul>
              <li>
                <input type="hidden" name="pageNumber" value="0">
                <input type="hidden" name="backupCache" value="">
                <input type="email" name="entry.0.single" value="" class="ss-q-short" id="entry_0" placeholder="seu@email.com">
              </li>
              <li>
                <input type="submit" name="submit" value="Quero Receber!" id="submit-newsletter">
              </li>
            </ul> 
          </form>
          <ul>
          <li class="ie8"><a href="https://docs.google.com/spreadsheet/viewform?formkey=dFhxZ2tDalFiclU4T2FLZVY4UXVUc2c6MQ&ifq" rel="nofollow">Receba as Novidades e Lançamentos</a></li>
          </ul>
        </div>
        <ul class="footer-payments">
          <li><img class="accepts-paypal" src="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/accepts_paypal.png?58522" border="0" alt="Paypal" width="130" height="80"/></li>
          <li><img class="accepts-pagseguro" src="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/logopagseguro.png?58522" border="0" alt="PagSeguro" width="180" height="26"/></li>
        </ul>
      </div>
    </div>
  </footer>

  
    <script>
        $(function() {
          $('#checkout').click(function () {
            _gaq.push(['_trackPageview', '/checkout/finalizaCompra']);
          });

          $('.book-suggest').click(function () {
            var book = $(this).data('book');
            _gaq.push(['_trackEvent', 'Recomendação', 'Livro', book]); 
          });
        });
    </script>
    
        <noscript><img height="1" width="1" alt="" style="display:none"
        src="https://www.facebook.com/offsite_event.php?id=6009930053200&amp;value=0&amp;currency=USD"
        /></noscript>
    
   
   

  
  


  <script>
    $(function() {
      $('a[href^="http"]')
         .not('.dont-track')
         .filter(function(index) {
            var ccb = $(this).attr('href').indexOf("casadocodigo.com.br");
            if (ccb == -1) ccb = $(this).attr('href').indexOf("localhost");

            return ccb != 7 && ccb != 11;
         })
       .click(function(event) {
         var domain = this.href;
         domain = domain.substring(7);
         domain = domain.substring(0, domain.indexOf('/'));

         if (domain.substring(0, 4) == 'www.')
           domain = domain.substring(4);
           
         _gaq.push(['_trackPageview', '/LinkExterno/' + this.href]);
       });
     });
  </script>
</body>
</html>
