package com.example.gateway.admin.routers;

    import com.example.gateway.admin.handlers.UserHandler;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.MediaType;
    import org.springframework.web.reactive.function.server.RequestPredicates;
    import org.springframework.web.reactive.function.server.RouterFunction;
    import org.springframework.web.reactive.function.server.RouterFunctions;
    import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> routeUser(UserHandler userHandler) {
        return RouterFunctions
            .route(RequestPredicates.GET("/getToken")
                    .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
                userHandler::getToken);
    }
}
