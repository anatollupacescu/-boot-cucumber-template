package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Configuration
    @Profile("default")
    public static class RealConfiguration {
        @Bean
        public String configReader(@Value("${app.version}") String version) {
            System.out.println("=====================Got version: " + version);
            return version;
        }
    }

    @Configuration
    @Profile("test")
    public static class TestConfiguration {
        @Bean
        public String configReader(@Value("${my.version}") String version) {
            System.out.println("=====================Got version: " + version);
            return version;
        }
    }
}
