package com.hmall.gateway.filter;

import com.hmall.common.exception.UnauthorizedException;
import com.hmall.gateway.config.AuthProperties;
import com.hmall.gateway.utils.JwtTool;
import io.netty.handler.codec.http2.Http2PushPromiseFrame;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.http.HttpResponse;
import java.security.KeyPair;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    private final AuthProperties authProperties;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    private final JwtTool jwtTool;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //判断是否放行
        if(isExclude(request.getPath().toString())){
            return chain.filter(exchange);
        }

        //获取token
        String token = null;
        HttpHeaders headers = request.getHeaders();
        List<String> authorization = headers.get("authorization");
        if(authorization!=null && !authorization.isEmpty()){
            token = authorization.get(0);
        }
        Long userid = null;
        try {
             userid = jwtTool.parseToken(token);
        } catch (UnauthorizedException e) {
            ServerHttpResponse httpResponse = exchange.getResponse();
            httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return httpResponse.setComplete();
        }
        String userstring = userid.toString();
        ServerWebExchange change = exchange.mutate().request(builder -> builder.header("user-info", userstring)).build();


        return chain.filter(change);
    }

    private boolean isExclude(String path) {
        for (String pathpattern:authProperties.getExcludePaths()){
            if(antPathMatcher.match(pathpattern,path))return true;
        }

        return false;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
