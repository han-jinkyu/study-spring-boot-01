package com.example.demo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * AbstractTest
 * 테스트를 위해 필요한 필수 요소들을 모아놓은 클래스
 */
// ExtendWith: 주석된 클래스 내부에서 파라미터로 받은 클래스를 사용하게 한다 => RunWith는 JUnit4
@ExtendWith(SpringExtension.class)
// SpringBootTest: 테스트를 위한 애노테이션
// classes: ApplicationContext를 불러오기 위한 컴포넌트 클래스를 설정한다
@SpringBootTest(classes = DemoApplication.class)
// WebAppConfiguration: ApplicationContext는 WebApplicationContext여야 한다는 선언
@WebAppConfiguration
public abstract class AbstractTest {

    /**
     * MockMvc: 웹 애플리케이션을 배포하지 않고도 스프링MVC를 재현하는 클래스
     */
    protected MockMvc mvc;

    /**
     * 서블릿에서 사용되는 Context.
     * DispatcherServlet이 사용하는 웹 관련 Bean을 등록한다.(예를 들어 컨트롤러 등)
     * DispatcherServlet란? 애플리케이션으로 들어오는 모든 요청을 처리하는 컨트롤러
     */
    @Autowired
    WebApplicationContext webApplicationContext;
    
    /**
     * 테스트 전에 필요한 내용을 정리하는 메소드
     */
    protected void setUp() {
        // MVC를 재현하는데 필요한 Context를 등록하여 빌드한다
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 오브젝트를 JSON 스트링으로 매핑한다
     * @param obj 변환하고자 하는 오브젝트
     * @return 변환된 JSON 스트링
     * @throws JsonProcessingException JSON화하는 과정에서 일어나는 예외
     */
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * JSON을 주어지는 오브젝트 타입으로 매핑한다
     * @param <T> 변환할 클래스 타입
     * @param json 변환하고자 하는 JSON 스트링
     * @param clazz 변환할 클래스 정보
     * @return 변환된 오브젝트
     * @throws JsonParseException JSON 파싱에서 일어나는 예외
     * @throws JsonMappingException JSON 매핑 중에 일어나는 예외
     * @throws IOException IO예외
     */
    protected <T> T mapFromJson(String json, Class<T> clazz) 
        throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
}