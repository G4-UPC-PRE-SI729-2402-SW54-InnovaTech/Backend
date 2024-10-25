package pe.upc.connexbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase principal para iniciar la aplicación Spring Boot.
 */
@SpringBootApplication (scanBasePackages = "pe.upc.connexbackend")
@EnableJpaAuditing
public class ConnexBackendApplication{

    public static void main(String[] args) {
        SpringApplication.run(ConnexBackendApplication.class, args);
    }

}
