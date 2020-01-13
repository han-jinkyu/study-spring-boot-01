package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
}
