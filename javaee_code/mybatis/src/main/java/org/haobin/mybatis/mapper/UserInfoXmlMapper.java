package org.haobin.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     *
     * @param userInfo
     * @return
     */
    Integer insert(UserInfo userInfo);

    Integer insert2(UserInfo userInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 修改
     *
     * @return
     */
    Integer update(String password, Integer id);


    /**
     * where 标签
     */
    List<UserInfo> queryUserByWhere(@Param("userName") String userName, @Param("age") Integer age);

    Integer update2(UserInfo userInfo);

    /**
     * 批量删除
     */
    Integer batchDelete(@Param("ids") List<Integer> ids);
}
