package br.com.casadocodigo.loja.infra.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;

public class SetAttributeScopeProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		if (bean.getClass().getGenericSuperclass() instanceof Class) {
			Class<?> superClass = (Class<?>) bean.getClass()
					.getGenericSuperclass();
			if (superClass.isAnnotationPresent(Scope.class)) {
				RequestContextHolder.currentRequestAttributes().setAttribute(beanName, bean, WebRequest.SCOPE_SESSION);
			}
		}
		return bean;
	}
}
