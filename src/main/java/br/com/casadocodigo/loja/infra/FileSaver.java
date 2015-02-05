package br.com.casadocodigo.loja.infra;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, String fileName, Part summary) {
		String realPath = request.getServletContext().getRealPath("/"+baseFolder);
		try {
			String path = realPath+"/"+fileName;
			summary.write(path);
			return baseFolder+"/"+fileName;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
