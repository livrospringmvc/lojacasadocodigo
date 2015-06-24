package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfiguration.class,
				AppWebConfiguration.class, JPAConfiguration.class,
				JPAProductionConfiguration.class,AmazonConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Tem que colocar aqui para ser adicionado no carregamento da servlet
		// base
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(RequestContextListener.class);
		servletContext.setInitParameter(
				AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "dev");

	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new OpenEntityManagerInViewFilter() };
	}

}
