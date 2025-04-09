package com.consulta.credito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.consulta.credito.entity")
@EnableJpaRepositories("com.consulta.credito.repository")
public class CreditoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditoApplication.class, args);
    }
}
