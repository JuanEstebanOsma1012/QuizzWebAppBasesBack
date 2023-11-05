package co.uniquindio.edu.quizzwebapp;

import co.uniquindio.edu.quizzwebapp.model.entities.Categoria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class QuizzWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizzWebAppApplication.class, args);
    }

}
