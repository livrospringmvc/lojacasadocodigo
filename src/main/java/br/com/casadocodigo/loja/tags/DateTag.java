package br.com.casadocodigo.loja.tags;

import org.springframework.web.servlet.tags.form.InputTag;

public class DateTag extends InputTag{

	@Override
	protected String getType() {
		return "date";
	}
}
