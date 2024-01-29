package org.example.springmvc_demo;

import lombok.Data;

/**
 * @author 刘浩彬
 * @date 2024/1/29
 */
@Data
public class MessageInfo {
    
    private String from;
    private String to;
    private String message;

    // 换一个新工具 lombook @Data
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

}
