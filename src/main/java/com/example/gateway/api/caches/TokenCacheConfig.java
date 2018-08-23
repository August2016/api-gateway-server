package com.example.gateway.api.caches;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * cache 相关配置
 */
@Component
@ConfigurationProperties(prefix = "gateway.cache.token")
@Data
@ToString
public class TokenCacheConfig {

    /**
     * 超时时间
     */
    @Value("${expireTime:2400}")
    private Integer expireSeconds;

    /**
     * 最大缓存数量
     */
    @Value("${maxSize:1000000}")
    private Integer maxSize;
}
