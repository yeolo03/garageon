package cf.garageon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// component scan package 명이 잘못걸림
@SpringBootApplication(scanBasePackages = "cf.garageon.app")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
