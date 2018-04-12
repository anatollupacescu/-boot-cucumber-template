package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(App.class)
                .sources(AppConfig.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
