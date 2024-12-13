package org.haobin.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.haobin.mybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘浩彬
 * @date 2024/2/28
 */
@Slf4j
@SpringBootTest
class UserInfoXmlMapperTest {
    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;

    @Test
    void queryUserList() {
        log.info(userInfoXmlMapper.queryUserList().toString());
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(("lisi"));
        userInfo.setAge(15);
        userInfo.setPassword("123456");
        userInfo.setGender(1);
        Integer result = userInfoXmlMapper.insert(userInfo);
        log.info("result:" + result + ",id:" + userInfo.getId());
    }

    @Test
    void delete() {
        userInfoXmlMapper.delete(6);
    }

    @Test
    void update() {
        userInfoXmlMapper.update("admin", 2);
    }

    @Test
    void queryUserList2() {
        log.info(userInfoXmlMapper.queryUserList().toString());
    }

    @Test
    void insert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(("lisi"));
        userInfo.setAge(15);
        userInfo.setPassword("123456");
//        userInfo.setGender(1);
        Integer result = userInfoXmlMapper.insert2(userInfo);
        log.info("result:" + result + ",id:" + userInfo.getId());
    }

    @Test
    void queryUserByWhere() {
        log.info(userInfoXmlMapper.queryUserByWhere(null, 15).toString());
    }

    @Test
    void update2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lisi");
        userInfo.setAge(100);
        userInfo.setPassword("123456");
        userInfo.setId(11);
        Integer result = userInfoXmlMapper.update2(userInfo);
    }

    @Test
    void batchDelete() {
        userInfoXmlMapper.batchDelete(Arrays.asList(1,2,3));
    }
}