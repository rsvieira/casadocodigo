package br.com.casadocodigo.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ramon Vieira
 *
 */

@Component
public class FileSaver {
	
	@Autowired
	HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file) {
		
		try {
			
			String realPath = request.getServletContext().getRealPath("/resources/" + baseFolder);
			String path = realPath + "/" + file.getOriginalFilename();
			
			System.out.println("-------------------------------------");
			System.out.println("realPath = " + realPath);
			System.out.println("path = " + path);
			System.out.println("-------------------------------------");
			
			file.transferTo(new File(path));
			
			return baseFolder + "/" + file.getOriginalFilename();
			
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
