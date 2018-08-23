package com.example.gateway.api.dtos;

import lombok.Data;
import lombok.ToString;

/**
 * 请求参数格式
 */
@Data
@ToString
public class ReqData {
    private String timestamp;
    private String appId;
    private String appKey;
    private String data;
}
