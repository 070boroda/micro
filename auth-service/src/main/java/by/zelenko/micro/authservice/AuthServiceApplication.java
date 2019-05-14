package by.zelenko.micro.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
/*@EnableJpaRepositories(basePackages = "by.zelenko.micro.zuulauthservice.repository")
@ComponentScan("by.zelenko.micro")
@EntityScan({"by.zelenko.micro.zuulauthservice.entity"})*/
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
