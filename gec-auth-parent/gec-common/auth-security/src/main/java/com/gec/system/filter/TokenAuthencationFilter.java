//package com.gec.system.filter;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//// 认证解析过滤器
//public class TokenAuthencationFilter extends OncePerRequestFilter {
//
//    // 空参构造
////    public TokenAuthencationFilter() {
////
////    }
//
//    private RedisTemplate redisTemplate;
//
//    public TokenAuthencationFilter(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//
//    // 过滤器 方法
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        logger.info("uri:" + request.getRequestURI());
//
//        //如果是登录接口，直接放行
//        if ("/admin/system/index/login".equals(request.getRequestURI()) || "/admin/system/upload/uploadImage".equals(request.getRequestURI()) || "/admin/system/upload/uploadVideo".equals(request.getRequestURI())) {
//            chain.doFilter(request, response);
//            return;
//
//        }
//    }
//}