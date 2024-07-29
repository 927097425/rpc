package com.example.tlias.Filter;

import com.alibaba.fastjson.JSONObject;
import com.example.tlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import com.example.tlias.pojo.Result;
import java.io.IOException;

@Slf4j
//@WebFilter("/*")
public class LoginFliter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rsp = (HttpServletResponse) servletResponse;

        String url = String.valueOf(req.getRequestURL());
        if(url.contains("login")){
            log.info("捕获到登录请求");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String jwt = req.getHeader("token");
        if(jwt == null ||jwt.isEmpty()){
            log.info("Jwt为空");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            rsp.getWriter().write(notLogin);
            return;
        }
        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            log.info("Jwt验证失败");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            rsp.getWriter().write(notLogin);
            return;
        }
        log.info("Jwt验证成功");
        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
