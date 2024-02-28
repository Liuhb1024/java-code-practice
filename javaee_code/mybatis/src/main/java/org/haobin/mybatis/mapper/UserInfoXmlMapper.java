package org.haobin.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.haobin.mybatis.model.UserInfo;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/2/28
 */
@Mapper
public interface UserInfoXmlMapper {
    List<UserInfo> queryUserList();
    List<UserInfo> queryUserList2();

    /**
     * 增加
     * @param userInfo
     * @return
     */
    Integer insert(UserInfo userInfo);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 修改
     * @return
     */
    Integer update(String password, Integer id);
}
