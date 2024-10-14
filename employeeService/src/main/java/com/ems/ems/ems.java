package com.ems.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class ems {

    public static void main(String[] args) {
        SpringApplication.run(ems.class, args);
    }

    @Bean
    @LoadBalanced  // Enables client-side load balancing with Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

     /* @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
 */


}
