package pe.upc.connexbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

    @Configuration
    public static class Myconfiguration{
        @Bean
        public WebMvcConfigurer corsConfigurer(){
            return new WebMvcConfigurer(){
                @Override
                public void addCorsMappings(CorsRegistry registry){
                    registry.addMapping("/**")
                            .allowedMethods("HEAD","GET", "POST", "PUT", "DELETE","PATCH");
                }
            };
        }
    }
}
