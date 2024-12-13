package org.haobin.kaptcha;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 刘浩彬
 * @date 2024/2/26
 */
@RestController
@RequestMapping("/admin")
public class KaptchaController {
    public static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";
    public static final String KAPTCHA_SESSION_DATE = "KAPTCHA_SESSION_DATE";
    public static final long TIME_OUT = 60 * 1000; // 1min 毫秒

    /**
     * 校验验证码是否正确
     *
     * @param inputCaptcha 用户输入的验证码
     * @return
     */
    @RequestMapping("/check")
    public boolean check(String inputCaptcha, HttpSession session) {
        // 1. 判断输入的验证码是否为空
        if (!StringUtils.hasLength(inputCaptcha)) {
            return false;
        }
        // 2. 获取生成的验证码
        // 正确的验证码（生成验证码）
        // 3. 比对 生成的验证码和输入的验证码是否一致
        // 4. 确认验证码是否过期
        String saveCaptcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        Date saveCaptchaDate = (Date) session.getAttribute(KAPTCHA_SESSION_DATE);
        // 不区分大小写
        if (inputCaptcha.equalsIgnoreCase(saveCaptcha)) {
            if (saveCaptchaDate != null || System.currentTimeMillis() - saveCaptchaDate.getTime() < TIME_OUT) {
                return true;
            }
        }
        return false;



    }
}
