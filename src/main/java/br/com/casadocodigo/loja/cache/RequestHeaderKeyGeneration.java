package br.com.casadocodigo.loja.cache;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.WebRequest;

@Component("headerKeyGenerator")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class RequestHeaderKeyGeneration implements KeyGenerator{
	
	@Autowired
	private WebRequest request;

	@Override
	public Object generate(Object target, Method method, Object... params) {
		SimpleKeyGenerator simpleKeyGenerator = new SimpleKeyGenerator();
		String header = request.getHeader(HttpHeaders.ACCEPT);
		Object delegateKey = simpleKeyGenerator.generate(target, method, params);
		return new RequestHeaderKey(header,delegateKey);
	}

}
