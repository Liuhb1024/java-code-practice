package org.example.springmvc_demo.controler;

import org.example.springmvc_demo.model.MessageInfo;
import org.example.springmvc_demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/1/29
 */
@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    private List<MessageInfo> messageInfos = new ArrayList<>();

    @RequestMapping("/publish")
    public boolean publishMessage(MessageInfo messageInfo){
        if (!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage())){
            return false;
        }
        //暂时存放在内存中
//        messageInfos.add(messageInfo);
        //把数据放在mysql当中
        messageService.insertMessage(messageInfo);
        return true;
    }

    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        return messageService.queryList();
    }
}