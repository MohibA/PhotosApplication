package com.example.PhotosApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.example.PhotosApp.model"})
public class PhotosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotosAppApplication.class, args);

	}

}
