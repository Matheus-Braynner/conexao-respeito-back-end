package br.com.grupoconexao.msbff.msbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@FeignClient
public class MsBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBffApplication.class, args);
	}

}
