package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileController
 */
@RestController
public class FileController {

    /**
     * 테스트 파일 경로
     */
    String filepath = "/";

    /**
     * 테스트 파일명
     */
    String filename = "test.jpg";
    
    /**
     * 파일을 업로드한다
     * @param uploadFile 업로드된 파일
     * @return 업로드 후 표시할 리스폰스의 바디
     * @throws IOException 파일 읽고 쓰기 시에 일어날 수 있는 IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestParam MultipartFile uploadFile) throws IOException {
        File destFile = new File(filepath + uploadFile.getOriginalFilename());
        uploadFile.transferTo(destFile);
        return "File is uploaded successfully";
    }

    /**
     * 파일을 다운로드한다
     * @return 다운로드 파일을 담은 리스폰스
     * @throws IOException 파일 읽고 쓰기 시에 일어날 수 있는 IOException
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> download() throws IOException {
        // 파일 정보 객체를 생성한다
        String downloadFilename = filepath + filename;
        File originFile = new File(downloadFilename);

        // InputStreamResource 객체를 생성한다
        InputStreamResource resource = new InputStreamResource(new FileInputStream(originFile));

        // 헤더를 작성한다
        HttpHeaders headers = new HttpHeaders();

        // 리스폰스 컨텐츠가 어떻게 보여질지 정의
        headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", downloadFilename));

        // 캐시를 어떻게 동작하게 할 것인가 정의
        headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");

        // Cache-Control의 http/1.0 버전
        headers.add(HttpHeaders.PRAGMA, "no-cache");

        // 유효기간. Cache-Control이 있으면 무시된다
        headers.add(HttpHeaders.EXPIRES, "0");

        return ResponseEntity.ok()
            .headers(headers)
            .contentLength(originFile.length())
            .contentType(MediaType.IMAGE_JPEG)
            .body(resource);
    }
}