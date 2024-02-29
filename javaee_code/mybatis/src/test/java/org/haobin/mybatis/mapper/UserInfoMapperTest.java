package org.haobin.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘浩彬
 * @date 2024/2/29
 */
@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryUserInfo2() {
        log.info(userInfoMapper.queryUserInfo2(1).toString());
    }

    @Test
    void queryUserInfoByName() {
        log.info(userInfoMapper.queryUserInfoByName("admin").toString());
    }

    @Test
    void queryUserInfoByName2() {
        log.info(userInfoMapper.queryUserInfoByName2("admin").toString());
        // BadSqlGrammarException 报错了
        // 因为 $ String 参数是直接拼接的
    }

    @Test
    void queryUserInfoByName3() {
        log.info(userInfoMapper.queryUserInfoByName3("' or 1 =  '1").toString());

    }

    @Test
    void queryUserByOrder() {
        log.info(userInfoMapper.queryUserByOrder("desc").toString());
    }

    @Test
    void queryUserByLike() {
        log.info(userInfoMapper.queryUserByLike("admin").toString());
    }

    @Test
    void queryUserByLike2() {
        log.info(userInfoMapper.queryUserByLike2("admin").toString());
    }

    @Test
    void batchDelete() {
        userInfoMapper.batchDelete(Arrays.asList(5,6,7));
    }
}