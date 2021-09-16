package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.entity.UserName;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private UserController userController;
    //需要给出服务端口
    @LocalServerPort
    int port;

    private String url = "http://localhost:";

    @Test
    public void test2() {
        url += this.port + "/api/insert";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 444);
        map.put("name","chg");
        String res = null;
        try {
            res = doPost(url, map, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
    @Test
    public void test3(){
        url += this.port + "/api/find";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 11);
        String res = null;
        try {
            res = doPost(url, map, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
    public static <T> T doPost(String url, Map<String, Object> params, Class<T> returnClass)
            throws Exception {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        MediaType type = MediaType.APPLICATION_JSON_UTF8;

        headers.setContentType(type);

        String value = new ObjectMapper().writeValueAsString(params);

        HttpEntity entity = new HttpEntity(value, headers);
        ResponseEntity<T> resp = rest.postForEntity(url, entity, returnClass);
        if (resp.getStatusCode() != HttpStatus.OK) {
            throw new Exception("服务调用失败：" + url + ";" + resp.getStatusCode());
        }
        return resp.getBody();
    }
}
