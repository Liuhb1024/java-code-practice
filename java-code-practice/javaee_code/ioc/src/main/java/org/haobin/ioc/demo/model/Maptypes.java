package org.haobin.ioc.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author 刘浩彬
 * @date 2024/2/25
 */
@Component
@Data
@ConfigurationProperties("maptypes")
public class Maptypes {
    private HashMap<String, String> map;
}
