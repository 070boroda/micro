package by.zelenko.micro.zuulauthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableJpaRepositories(basePackages = "by.zelenko.micro.zuulauthservice.repository")
@ComponentScan("by.zelenko.micro")
@EntityScan({"by.zelenko.micro.zuulauthservice.entity"})
public class ZuulAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulAuthServiceApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
