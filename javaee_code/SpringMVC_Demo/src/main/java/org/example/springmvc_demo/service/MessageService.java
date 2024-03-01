package org.example.springmvc_demo.service;

import org.example.springmvc_demo.mapper.MessageMapper;
import org.example.springmvc_demo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/3/1
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public Integer insertMessage(MessageInfo messageInfo) {
        return messageMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> queryList() {
        return messageMapper.queryMessageList();
    }
}

