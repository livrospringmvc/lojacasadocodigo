package br.com.casadocodigo.loja.viewresolver;

import java.util.Locale;

import br.com.casadocodigo.loja.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

@Component
public class CustomXMLViewResolver implements LojaViewResolver {


    private final Jaxb2Marshaller marshaller;

	public CustomXMLViewResolver() {
        marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Product.class);
	}


	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		MarshallingView view = new MarshallingView();
		view.setMarshaller(marshaller);
//		view.setModelKey("products");
		return view;
	}
}