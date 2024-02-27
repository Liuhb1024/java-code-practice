package org.haobin.ioc.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘浩彬
 * @date 2024/2/26
 */
@RestController
@RequestMapping("/log")
public class LoggerController {
    public static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/printLog")
    public String printLog() {
        System.out.println("print log");
        logger.info("========我是日志对象打印的日志=======");
        return "success";
    }

    @RequestMapping("/LogLevel")
    public String printLog_pro() {
        logger.trace("我是trace级别的日志");
        logger.debug("我是debug级别的日志");
        logger.info("我是info级别的日志");
        logger.warn("我是warn级别的日志");
        logger.error("我是error级别的日志");
        return "success";
    }
}
