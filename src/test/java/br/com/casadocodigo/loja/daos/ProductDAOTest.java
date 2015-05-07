package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.AppWebConfiguration;
import br.com.casadocodigo.loja.builders.ProductBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppWebConfiguration.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
@WebAppConfiguration
public class ProductDAOTest {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Test
    public void shouldSumAllPricesOfEachBookPerTypeWithRepository() {

        List<Product> printedBooks = ProductBuilder
                .newProduct(BookType.PRINTED, BigDecimal.TEN).more(4)
                .buildAll();
        printedBooks.stream().forEach(productRepository::save);

        List<Product> ebooks = ProductBuilder
                .newProduct(BookType.EBOOK, BigDecimal.TEN).more(4).buildAll();
        ebooks.stream().forEach(productRepository::save);
        BigDecimal value = productRepository.sumPricesPerType(BookType.PRINTED);
        Assert.assertEquals(new BigDecimal(50).setScale(2), value);

    }


}
