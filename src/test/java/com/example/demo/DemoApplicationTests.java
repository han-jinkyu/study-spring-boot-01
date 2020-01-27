package com.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * DemoApplicationTests
 */
@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class DemoApplicationTests {

	/**
	 * ProductService
	 */
	@Autowired
	private ProductService productService;

	/**
	 * 상품 리스트를 얻은 경우 같은지
	 */
	@Test // JUnit5를 사용한다면 org.junit.jupiter.api.Test를 써야 한다!!!
	public void when_get_products_then_products_equals() {
		// given
		Collection<Product> list = Arrays.asList(
			new Product("1", "Honey"),
			new Product("2", "Almond")
		);

		// when
		Collection<Product> products = productService.getProducts();

		// then
		Assert.assertArrayEquals(list.toArray(), products.toArray());
	}
}
