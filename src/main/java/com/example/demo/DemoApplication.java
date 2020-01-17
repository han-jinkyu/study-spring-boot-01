package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 애플리케이션 시작 클래스
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * 프로그램의 시작점
	 * @param args 외부로부터 받는 인자
	 */
	public static void main(String[] args) {
		// 애플리케이션을 구동한다
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * RestTemplateBean을 생성하기 위한 메소드
	 * @return 생성된 RestTeamplteBean
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * CORS를 전역에 적용하기 위해 WebMvcConfigurer를 생성하기 위한 메소드
	 * @return 생성된 WebMvcConfigurer
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		// WebMvcConfigurerAdapter는 deprecated
		// WebMvcConfigurer는 인터페이스인데 default 메소드가 생겨서 Adapter가 필요없어졌다고 한다
		// cf. http://honeymon.io/tech/2018/03/13/spring-boot-mvc-controller.html
		return new WebMvcConfigurer() {

			/**
			 * CORS 매핑을 추가한다
			 */
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products")
					.allowedOrigins("http://localhost:8080");
			}
		};
	}
}
