package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Tem que colocar aqui para ser adicionado no carregamento da servlet base
		return new Class[]{ConfiguracaoAppWeb.class,ConfiguracaoJPA.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
