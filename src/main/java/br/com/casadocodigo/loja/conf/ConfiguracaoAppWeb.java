package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.casadocodigo.loja.controllers.HomeController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class})
public class ConfiguracaoAppWeb {

}
