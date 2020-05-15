package com.zhanglinchun.springboot.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import java.io.IOException;
import java.util.EnumSet;

public class ServletWebApplicationInitializer implements Filter,WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //注册Filter  FilterRegistration
        FilterRegistration.Dynamic filter = servletContext.addFilter("userFilter", ServletWebApplicationInitializer.class);
        //配置Filter的映射信息
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----过滤器初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----Filter执行----");
        // 让目标资源执行，放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}
