package br.com.casadocodigo.loja.models;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Named;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
@Lazy
public class ShoppingCart {

	private Map<Product, Integer> products = new LinkedHashMap<Product, Integer>();
	
	
	public void add(Product product){
		products.put(product, getQuantity(product));
	}


	public Integer getQuantity(Product product) {
		if(!products.containsKey(product)){
			return 1;
		}
		return products.get(product);
	}
	
	public Collection<Product> list(){
		return products.keySet();
	}
	
}
