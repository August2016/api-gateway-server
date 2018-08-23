package com.example.gateway.admin.dtos;

import lombok.Data;
import lombok.ToString;

/**
 * 用户获取token请求
 */
@Data
@ToString
public class UserTokenReq {

    /**
     * 用户App key
     */
    private String appKey;

    /**
     * 请求时间
     */
    private Long timestamp;

    /**
     * 签名 blowfish(appKey + timestamp + appSec)
     */
    private String sign;
}
