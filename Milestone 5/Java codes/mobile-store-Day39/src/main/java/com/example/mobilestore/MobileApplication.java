package com.example.mobilestore;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class MobileApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
//		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//		.selectors(DiscoverySelectors.selectPackage("com.example.mobilestore.test"))
//		.build();
//
//		Launcher launcher = org.junit.platform.launcher.core.LauncherFactory.create();
//		
//	
	}
}