package br.com.grupoconexao.msinvolved;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.security.SecurityPermission;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MsInvolvedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInvolvedApplication.class, args);
	}

}
