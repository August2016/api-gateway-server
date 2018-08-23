package com.example.gateway.api.caches;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * token缓存
 */
@Component
public class TokenCache {

    @Autowired
    private TokenCacheConfig config;

    private static Cache<String, Token> cache;

    @PostConstruct
    public void init() {
        cache = Caffeine.newBuilder()
            .expireAfterWrite(config.getExpireSeconds(), TimeUnit.SECONDS)
            .maximumSize(config.getMaxSize())
            .build();
    }

    public static Token get(String token) {
        return cache.getIfPresent(token);
    }

    public static void put(Token token) {
        cache.put(token.getToken(), token);
    }

    /**
     * 存储token同用户对应关系
     */
    @Data
    @ToString
    public static class Token {
        /**
         * 用户ID
         */
        private String userId;

        /**
         * token
         */
        private String token;

        /**
         * 密码钥匙
         */
        private String appKey;

        /**
         * 密码钥匙
         */
        private String appSec;

        /**
         * 生成时间
         */
        private Long createTimeMills;
    }

}
