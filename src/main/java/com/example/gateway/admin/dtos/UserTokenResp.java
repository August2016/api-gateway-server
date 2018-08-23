package com.example.gateway.admin.dtos;

import lombok.Data;
import lombok.ToString;

/**
 * 请求参数格式
 */
@Data
@ToString
public class UserTokenResp {
    private String appId;
    private String appKey;
    private String token;
    private Long expire;
}
