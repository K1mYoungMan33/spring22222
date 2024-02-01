package kroryi.spring22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spring22Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring22Application.class, args);
    }

}
