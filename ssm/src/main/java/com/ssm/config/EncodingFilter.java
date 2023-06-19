package com.ssm.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//编码过滤器，把所有的请求和响应都进行编码过滤，防止出现乱码
@WebFilter(filterName = "encodingFilter",urlPatterns = "/*")
public class EncodingFilter  implements Filter {

    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {}
}
