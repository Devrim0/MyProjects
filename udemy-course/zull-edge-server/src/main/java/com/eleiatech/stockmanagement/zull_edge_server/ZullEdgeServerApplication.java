package com.eleiatech.stockmanagement.zull_edge_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
@CrossOrigin(origins = "*", maxAge = 3600)
public class ZullEdgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullEdgeServerApplication.class, args);
	}

}
