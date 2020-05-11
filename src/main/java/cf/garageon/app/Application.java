package cf.garageon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cf.garageon.app.util")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
