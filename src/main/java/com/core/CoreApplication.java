package com.core;

import com.core.service.Geo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        Geo.shopGrid = new HashMap<>();

        SpringApplication.run(CoreApplication.class, args);
    }
}
