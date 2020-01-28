package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.model.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * ProductServiceControllerTest
 */
public class ProductServiceControllerTest extends AbstractTest {

    /**
     * 테스트에 필요한 기본 URI
     */
    private final String baseUri = "/products";

    /**
     * 사전준비
     * @BeforeEach를 붙여야지만 실행됨. JUnit4는 @Before
     */
    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    /**
     * 상품을 취득하는 테스트
     * @throws Exception 도중에 일어나는 모든 예외
     */
    @Test
    public void getProducts() throws Exception {
        // 목업 리퀘스트를 작성한다
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
            .get(baseUri)
            // Accept 헤더를 보낸다 (클라이언트가 이해할 수 있는 미디어 타입 설명)
            .accept(MediaType.APPLICATION_JSON_VALUE);

        // 실행하고 결과를 반환
        MvcResult mvcResult = mvc.perform(builder).andReturn();

        // 리스폰스를 얻는다
        MockHttpServletResponse response = mvcResult.getResponse();

        // 상태가 200이면 성공
        int status = response.getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }

    /**
     * 상품을 작성하는 테스트
     * @throws Exception 도중에 일어나는 모든 예외
     */
    @Test
    public void createProduct() throws Exception {
        // 테스트에 사용할 상품 작성
        Product product = new Product(3L, "Ginger");
        String inputJson = super.mapToJson(product);

        // 목업 리퀘스트를 작성한다
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
            .post(baseUri)
            // Content-Type 헤더를 보낸다. (클라이언트가 보내는 Content의 Type을 설명)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            // 리퀘스트의 Body에 들어갈 내용
            .content(inputJson);

        // 실행하고 결과를 반환
        MvcResult mvcResult = mvc.perform(builder).andReturn();

        // 리스폰스를 얻는다
        MockHttpServletResponse response = mvcResult.getResponse();

        // 상태가 200이면 성공
        int status = response.getStatus();
        assertEquals(HttpStatus.OK.value(), status);

        // 메시지가 제대로 돌아오면 성공
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is created successfully!");
    }

    /**
     * 상품을 갱신하는 테스트
     * @throws Exception 도중에 일어나는 모든 예외
     */
    @Test
    public void updateProduct() throws Exception {
        // 갱신할 상품을 작성한다
        Product product = new Product();
        product.setName("Lemon");
        String inputJson = super.mapToJson(product);

        // 목업 리퀘스트를 작성한다
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
            .put(baseUri + "/2")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(inputJson);

        // 실행하고 결과를 반환
        MvcResult mvcResult = mvc.perform(builder).andReturn();

        // 리스폰스를 얻는다
        MockHttpServletResponse response = mvcResult.getResponse();

        // 상태가 200이면 성공
        int status = response.getStatus();
        assertEquals(HttpStatus.OK.value(), status);

        // 메시지가 제대로 돌아오면 성공
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is updated successfully!");
    }

    /**
     * 상품을 삭제하는 테스트
     * @throws Exception 도중에 일어나는 모든 예외
     */
    @Test
    public void deleteProduct() throws Exception {
        // 목업 리퀘스트를 작성한다
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
            .delete(baseUri + "/2");

        // 실행하고 결과를 반환
        MvcResult mvcResult = mvc.perform(builder).andReturn();

        // 리스폰스를 얻는다
        MockHttpServletResponse response = mvcResult.getResponse();

        // 상태가 200이면 성공
        int status = response.getStatus();
        assertEquals(HttpStatus.OK.value(), status);

        // 메시지가 제대로 돌아오면 성공
        String content = response.getContentAsString();
        assertEquals(content, "Product is deleted successfully!");
    }
}