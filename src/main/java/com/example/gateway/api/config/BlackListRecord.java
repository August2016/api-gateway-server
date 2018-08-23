package com.example.gateway.api.config;

/**
 * 黑名单记录
 */
public class BlackListRecord {

    /**
     * IP地址
     */
    private String ip;

    /**
     * 限制类型
     */
    private Integer limitType;

    /**
     * 超限次数
     */
    private Integer limit;

    /**
     * 限制失效时间
     */
    private Long expireTime;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getLimitType() {
        return limitType;
    }

    public void setLimitType(Integer limitType) {
        this.limitType = limitType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
