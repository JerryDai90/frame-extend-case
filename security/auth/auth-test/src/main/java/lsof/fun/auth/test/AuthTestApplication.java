package lsof.fun.auth.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AuthTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthTestApplication.class, args);
	}

}
