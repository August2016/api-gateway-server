package com.example.gateway.admin.handlers;

import com.example.gateway.admin.dtos.UserTokenResp;
import com.example.gateway.utils.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 用户管理
 */
@Component
public class UserHandler {

    public Mono<ServerResponse> getToken(ServerRequest serverRequest) {
        String token = RandomStringUtils.nextString(32);

        UserTokenResp tokenDTO = new UserTokenResp();
        tokenDTO.setAppId("appId");
        tokenDTO.setToken(token);
        tokenDTO.setExpire(System.currentTimeMillis() + 12 * 60 * 60 * 1000);

        return ServerResponse.ok().body(BodyInserters.fromObject(tokenDTO)).delayElement(Duration.ofMillis(100));
    }

}
