package com.restclient;

import com.restclient.domain.ProductDTO;
import com.restclient.domain.ProductRequestDto;
import com.restclient.domain.ShoppingCart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	String productServiceUrl = "http://product:8080/products";
	String shoppingServiceUrl = "http://shopping:9000/carts";

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ProductRequestDto product = new ProductRequestDto("6",123456L,350,"this product is dope");

		ResponseEntity<ProductRequestDto> responce = restTemplate.postForEntity(productServiceUrl,product,ProductRequestDto.class);

		ResponseEntity<ProductDTO> recivedProduct = restTemplate.getForEntity(productServiceUrl+"/{id}",ProductDTO.class,"6");
		System.out.println("Product received from ProductService application");
		System.out.println(recivedProduct);

		ShoppingCart cart = restTemplate.postForObject(shoppingServiceUrl+"/{cartNumber}",recivedProduct, ShoppingCart.class,10);
		ShoppingCart recivedCart = restTemplate.getForObject(shoppingServiceUrl+"/{cartNumber}", ShoppingCart.class,10);

		System.out.println("\ncart received from ShoppingService application");
		System.out.println(recivedCart);
	}
}
