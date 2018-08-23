package com.example.gateway.api.caches;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * token缓存
 */
@Component
public class StoreCache {

    private static Cache<String, Token> cache;

    @PostConstruct
    public void init() {
        cache = Caffeine.newBuilder()
            .expireAfterWrite(4, TimeUnit.HOURS)
            .maximumSize(10000000)
            .build();
    }

    public static void put(String key, Token token) {
        cache.put(key, token);
    }

    public static Token get(String key) {
        return cache.getIfPresent(key);
    }

    public static void remove(String key) {
        cache.invalidate(key);
    }

    /**
     * 存储token同用户对应关系
     */
    @Data
    @ToString
    public static class Token {
        /**
         * 密码钥匙
         */
        private String secKey;

        /**
         * 用户ID
         */
        private String userId;

        /**
         * 生成时间
         */
        private Long timeMills;
    }

}
