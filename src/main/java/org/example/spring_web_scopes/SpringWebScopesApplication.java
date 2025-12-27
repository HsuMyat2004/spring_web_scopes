package org.example.spring_web_scopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.spring_web_scopes.application_scoped")

public class SpringWebScopesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebScopesApplication.class, args);
    }

}
