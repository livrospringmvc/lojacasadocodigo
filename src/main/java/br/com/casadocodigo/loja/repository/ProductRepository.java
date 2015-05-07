package br.com.casadocodigo.loja.repository;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author Tiarê Balbi Bonamini
 * @version 1.0.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p join fetch p.prices price where p.id = :id and price.bookType = :bookType")
    Product findBy(@Param("id") Integer id, @Param("bookType") BookType bookType);

    @Query("select sum(price.value) from Product p join p.prices price where price.bookType = :book")
    BigDecimal sumPricesPerType(@Param("book") BookType bookType);

}