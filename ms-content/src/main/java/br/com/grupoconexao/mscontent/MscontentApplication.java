package br.com.grupoconexao.mscontent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MscontentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscontentApplication.class, args);
	}

}
