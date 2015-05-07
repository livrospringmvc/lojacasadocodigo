package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.AppWebConfiguration;
import br.com.casadocodigo.loja.builders.ProductBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.conf.SecurityConfiguration;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Filter;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppWebConfiguration.class,
        JPAConfiguration.class, SecurityConfiguration.class,
        DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProductsControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    // pq tem apenas esse filtro
    @Autowired
    private Filter springSecurityFilterChain;
    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilters(springSecurityFilterChain).build();
    }

    @Test
    public void onlyAdminShoudAccessProductsForm()
            throws Exception {
        // poderia usar o isFound()
        this.mockMvc.perform(
                get("/produtos/form").with(
                        SecurityMockMvcRequestPostProcessors
                                .user("comprador@gmail.com").password("123456")
                                .roles("COMPRADOR"))).andExpect(
                status().is(403));
    }

    // verificar que os produtos estão sendo exibidos na lista
    @Test
    @Transactional
    public void shouldListAllBooksInTheHome()
            throws Exception {
        productRepository.save(ProductBuilder.newProduct().buildOne());

        ResultActions action = this.mockMvc.perform(get("/produtos"));
        ResultMatcher modelAndViewMatcher = new ResultMatcher() {

            @Override
            public void match(MvcResult result) throws Exception {
                ModelAndView mv = result.getModelAndView();
                List<Product> products = (List<Product>) mv.getModel().get("products");
                Assert.assertEquals(1, products.size());
            }
        };
        action.andExpect(modelAndViewMatcher).andExpect(
                MockMvcResultMatchers
                        .forwardedUrl("/WEB-INF/views/products/list.jsp"));

    }

}
