package org.haobin.mybatis.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.haobin.mybatis.model.UserInfo;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/2/27
 */

/**
 * 访问数据库
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 返回用户列表数据
     * @return
     */
//    @Select("select * from userinfo")
    /**
     * 查询数据的时候MyBatis 会获取结果中返回的列名并在 Java 类中查找相同名字的属性（忽略
     * ⼤⼩写）。 这意味着如果发现了 ID 列和 id 属性，MyBatis 会将列 ID 的值赋给 id 属性
     * 于是有三种解决办法
     * 1. 起别名
     * 2，结果映射
     * 3.开启驼峰命名
     *
     * 下面逐一展开
     * 1. 起别名
     */
    @Select("select id,username,password,age,gender,phone," +
            "delete_flag as deleteFlag, create_time as creatTime,update_time as updateTime from userinfo")
    List<UserInfo> queryUserList();

    /**
     * 2. 结果映射
     * @param userId
     * @return
     */
    @Select("select * from userInfo where id = #{id}")
    @Results(id = "BaseResult",value = {
            @Result(column = "delete_flag",property = "deleteFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    UserInfo queryUserInfo(Integer userId);

    @Select("select * from userinfo where username = #{name}")
    UserInfo queryUserInfoByName(String name);

    @Select("select * from userinfo where username = '${name}'")
    UserInfo queryUserInfoByName2(String name);

    /**
     * sql 注入
     * @param name
     * @return
     */
    @Select("select * from userinfo where username = '${name}'")
    List<UserInfo> queryUserInfoByName3(String name);

    @Select("select * from userInfo where id = ${id}")
    UserInfo queryUserInfo2(Integer userId);


    /**
     * @Result实现复用
     * @param userId
     * @param deleteFlag
     * @return
     */
    @ResultMap(value = "BaseResult")
    @Select("select * from userinfo where id = #{userId} and delete_flag = #{deleteFlag}")
    UserInfo queryUserInfoByDF(@Param("userId") Integer userId, @Param("deleteFlag") Integer deleteFlag);

    /**
     * 直接在 yml 文件中加上自动转换驼峰
     * @param userId
     * @param deleteFlag
     * @return
     */
    @Select("select * from userinfo where id = #{param1} and delete_flag = #{deleteFlag}")
    UserInfo queryUserInfoParam(Integer userId, Integer deleteFlag);

    /**
     *
     * 使用对象进行参数传递
     * 1. 如果没有使用 @Param 进行重命名，直接使用属性名就可以了
     * 2. 如果使用 @Param 进行重命名，使用 对象.属性名 来获取参数
     *
     * @param userInfo
     * @return
     */
    @Insert("insert into userinfo(username, password, age, gender, phone) " +
            "values (#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo(username, password, age, gender, phone) " +
            "values (#{userInfo.username},#{userInfo.password},#{userInfo.age}," +
            "#{userInfo.gender},#{userInfo.phone})")
    Integer insertByParam(@Param("userInfo") UserInfo userInfo);

    @Delete("delete from userinfo where id = #{id}")
    Integer delete(@Param(("id")) Integer id);

    @Update("update userinfo set password=#{password} where id=#{id}")
    Integer update(@Param("password") String password, @Param("id") Integer id);

    @Update("update userinfo set username=#{username}, password=#{password}, age=#{age} " +
            "where id = #{id}")
    Integer updateByOb(UserInfo userInfo);

    @Select("select  * from userinfo where username = '${name}' and password = '${password}'")
    List<UserInfo> queryUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Select("select * from  userinfo order by id ${order}")
    List<UserInfo>  queryUserByOrder(String order);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from  userinfo where username like '%${name}%'")
    List<UserInfo>  queryUserByLike(String name);

    @Select("select * from userinfo where username like CONCAT('%',#{name},'%')" )
    List<UserInfo>queryUserByLike2(String name);

    @Delete("<script>" +
            "delete from userinfo where id in "+
            "<foreach collection='list' separator=',' open='(' close=')' item='id'> "+
            "#{id} "+
            "</foreach> "+
            "</script> ")
    Integer batchDelete(List<Integer> ids);
}