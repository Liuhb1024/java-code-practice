package org.example.springmvc_demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘浩彬
 * @date 2024/1/29
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    private  List<MessageInfo>messageInfos = new ArrayList<>();

    @RequestMapping("/publish")
    public boolean publishMessage(MessageInfo messageInfo){
        if (!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength((messageInfo.getMessage()))){
            return false;
        }
        // 暂时存放在内存中
        messageInfos.add(messageInfo);
        return true;
    }

    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        for (MessageInfo messageInfo : messageInfos){

        }

        return messageInfos;
    }
}
