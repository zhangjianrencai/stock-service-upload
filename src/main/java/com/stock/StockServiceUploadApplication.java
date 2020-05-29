package com.stock;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class StockServiceUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceUploadApplication.class, args);
	}
	
	// Setting file upload size
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        // single file max size
        factory.setMaxFileSize(DataSize.ofMegabytes(10)); //KB,MB
        /// total files max size
        factory.setMaxRequestSize(DataSize.ofMegabytes(100));
        return factory.createMultipartConfig();
    }

}

