package br.com.casadocodigo.loja.infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class FileSaver {

	@Autowired
	private AmazonS3Client s3;

	public String write(String baseFolder, MultipartFile multipartFile) {
		try {
			s3.putObject("casadocodigo", multipartFile.getOriginalFilename(),
					multipartFile.getInputStream(), new ObjectMetadata());
			return "http://localhost:9444/s3/casadocodigo/"+multipartFile.getOriginalFilename()+"?noAuth=true";
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}

	}


}
