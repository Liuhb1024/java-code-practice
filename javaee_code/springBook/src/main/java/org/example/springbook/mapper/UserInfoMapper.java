package org.example.springbook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springbook.model.UserInfo;

/**
 * @author 刘浩彬
 * @date 2024/3/1
 */
@Mapper
public interface UserInfoMapper {

    @Select("SELECT * FROM user_info WHERE user_name = #{userName} AND delete_flag = 0")
    UserInfo queryByName(String userName);


}
