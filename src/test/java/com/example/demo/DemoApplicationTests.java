package com.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	public void when_get_products_then_products_equals() {
		// given
		List<Product> list = mock(List.class);
		when(list.get(0))
			.thenReturn(new Product("1", "Honey"));
		when(list.get(1))
			.thenReturn(new Product("2", "Almond"));

		// when
		// Collection<Product> products = productService.getProducts();

		// then
		// Assert.assertEquals(list, products);
	}
}
