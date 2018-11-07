package com.verizon.iprom.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.verizon.iprom.commons.AppConfig;
import com.verizon.iprom.commons.logging.AppLogger;

@SpringBootApplication
@ComponentScan(AppConfig.BASE_PACKAGES)
public class OrdersApplication {
    
    private static final AppLogger LOGGER = new AppLogger(OrdersApplication.class);
    
	public static void main(String[] args) {
	    
	    LOGGER.info("OrdersApplication.main(...)");
		SpringApplication.run(OrdersApplication.class, args);
	}
}
