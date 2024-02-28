package org.haobin.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.haobin.mybatis.model.ArticleInfo;

/**
 * @author 刘浩彬
 * @date 2024/2/28
 */
@Mapper
public interface ArticleInfoMapper {
    @Select("select " +
            " ta.*,tb.username, tb.age,tb.phone, tb.gender " +
            " from articleinfo ta left join userinfo tb on ta.uid = tb.id " +
            " where ta.id=#{id}")
    ArticleInfo queryArticleInfo(Integer id);
}
