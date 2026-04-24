package tech.gtech.basketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tech.gtech.basketservice.client.PlatziStoreClient;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class BasketserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasketserviceApplication.class, args);
	}

}
