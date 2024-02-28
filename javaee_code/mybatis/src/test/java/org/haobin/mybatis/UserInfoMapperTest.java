package org.haobin.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.haobin.mybatis.mapper.UserInfoMapper;
import org.haobin.mybatis.model.UserInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘浩彬
 * @date 2024/2/27
 */
@Slf4j
@SpringBootTest // 加载 spring 的运行环境
class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @BeforeEach
    void setUp() {
        log.info("setUp....");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown....");
    }

    @Test
    void queryUserList() {
        log.info(userInfoMapper.queryUserList().toString());
    }

    @Test
    void queryUserInfo() {
        log.info(userInfoMapper.queryUserInfo(1).toString());
    }

    @Test
    void queryUserInfoByDF() {
        log.info(userInfoMapper.queryUserInfoByDF(1, 0).toString());
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("123456");
        userInfo.setAge(111);
        userInfo.setGender(0);
        userInfo.setPhone("110110110");
        userInfoMapper.insert(userInfo);
    }

    @Test
    void insertByParam() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("123456");
        userInfo.setAge(111);
        userInfo.setGender(0);
        userInfo.setPhone("110110110");
        Integer result = userInfoMapper.insertByParam(userInfo);
        log.info("插入数据 result：" + result + "， id：" + userInfo.getId());
    }

    @Test
    void delete() {
        userInfoMapper.delete(9);
    }

    @Test
    void update() {
        userInfoMapper.update("zhaoliu",7);
    }

    @Test
    void updateByOb() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu888");
        userInfo.setPassword("1234dsa56");
        userInfo.setAge(99);

        userInfo.setId(7);
        userInfoMapper.updateByOb(userInfo);
    }

    @Test
    void queryUserInfoParam() {
        log.info(userInfoMapper.queryUserInfoByDF(1, 0).toString());

    }
}