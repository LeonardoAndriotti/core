package com.core;

import com.core.DTO.ShopDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class CoreApplication {

	public static HashMap<String, List<ShopDTO>> ShopGrid;

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
