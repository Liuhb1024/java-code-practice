package org.example.springmvc_demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 刘浩彬
 * @date 2024/1/24
 */
public class JSONUtils {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("zhangsan");
        userInfo.setAge(18);
        userInfo.setId(12);

        // 对象转 JSON
        String s = objectMapper.writeValueAsString(userInfo);
        System.out.println(s);

        // JSON 转成 java 对象
        UserInfo userInfo1 = objectMapper.readValue(s,UserInfo.class);
        System.out.println(userInfo1);
    }
}
