package br.com.casadocodigo.loja.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.ShoppingCart;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class,ProductDAO.class,FileSaver.class,ShoppingCart.class})
@EnableCaching
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	  resolver.setPrefix("/WEB-INF/views/");
	  resolver.setSuffix(".jsp");	 
	  return resolver;
	}
	
	@Bean//(name="messageSource")
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}
	
	@Bean
    public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
		
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
        registrar.registerFormatters(conversionService);	
		return conversionService;
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public CacheManager cacheManager(){
		return new ConcurrentMapCacheManager();
	}
	
	
	
}
