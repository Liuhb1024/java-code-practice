package org.haobin.mybatis.mapper;

import org.haobin.mybatis.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘浩彬
 * @date 2024/2/28
 */
@SpringBootTest
class ArticleInfoMapperTest {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void queryArticleInfo() {
        ArticleInfo articleInfo = articleInfoMapper.queryArticleInfo(1);
        System.out.println(articleInfo);
    }
}