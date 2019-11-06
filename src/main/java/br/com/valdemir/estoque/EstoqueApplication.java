package br.com.valdemir.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"br.com.valdemir.estoque"})
@EnableJpaRepositories(basePackages="br.com.valdemir.estoque.repository")
@EnableTransactionManagement
@EntityScan(basePackages="br.com.valdemir.estoque.entity")
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}
}
