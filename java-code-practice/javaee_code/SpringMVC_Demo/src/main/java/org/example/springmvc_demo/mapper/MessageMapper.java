package org.example.springmvc_demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.springmvc_demo.model.MessageInfo;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/3/1
 */
@Mapper
public interface MessageMapper {
    /**
     * 插入留言信息
     * @return
     */
    @Insert("insert into message_info (`from`, `to`, `message`) values (#{from}, #{to}, #{message})")
    Integer insertMessage(MessageInfo messageInfo);
    /**
     * 查询留言信息
     */
    @Select("select * from message_info where delete_flag <> 1")
    List<MessageInfo> queryMessageList();
}