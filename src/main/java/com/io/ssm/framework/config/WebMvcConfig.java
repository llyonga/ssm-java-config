package com.io.ssm.framework.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author lvyongb.
 * @Description spring mvc 容器配置
 * @date 2018/4/26.
 *
 * 此处引用的spring 5.0，WebMvcConfigurerAdapter 在Spring5.0已被废弃
 * 因此解决方法：
 * 1 直接实现WebMvcConfigurer （官方推荐）
 * 例如：
 * @Configuration public class WebMvcConfg implements WebMvcConfigurer { //todo }
 * 2 直接继承WebMvcConfigurationSupport
 * 例如：
 * @Configuration public class WebMvcConfg extends WebMvcConfigurationSupport { //todo }
 *具体可以查看官方文档
 *
 */
@Configuration  //标识这是一个Java配置类
@EnableWebMvc  //注解用于启动Spring MVC特性
@Import({ThymeleafConfig.class})   //用于引入其他配置类
@ComponentScan(basePackages = {"com.io.ssm.module"},
        //在主容器中排出了，这里需要添加扫描
        includeFilters =
                {@ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = {ControllerAdvice.class, Controller.class})})
public class WebMvcConfig implements WebMvcConfigurer {
//public class WebMvcConfig extends WebMvcConfigurationSupport{

    private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfig.class);

    /**
     * 启用spring mvc 的注解（不启用只能通过显示的配置）
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置静态资源的映射
     * @param registry
     */
    //@Override
    //public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //    registry.addResourceHandler("/assets/**")
    //            .addResourceLocations("/assets/")
    //            .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS).cachePublic());
    //}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        System.out.println("addResourceHandlers-------------->>：加载静态资源。。。。。。。。。。。。。。。。。。。。。。。。");
        /*
        配置加载静态资源可以采用下面的方式，但是这样会显得累赘
        registry.addResourceHandler("/static/img*//**").addResourceLocations("/static/img/");
        registry.addResourceHandler("/static/js*//**").addResourceLocations("/static/js/");
       */
//        String[] pathPatterns = new String[]{
//                "/static/img/**","/static/js/**","/static/i/**","/static/fonts/**","/static/css/**","/static/html/**","/**/*.html"
//        };
//        String[] resourceLocations = new String[]{
//                "/static/img/","/static/js/","/static/i/","/static/fonts/","/static/css/","/static/html/","/"
//        };

//        registry.addResourceHandler(pathPatterns).addResourceLocations(resourceLocations)
//                .setCacheControl(CacheControl.maxAge(31536000, TimeUnit.MILLISECONDS).cachePublic());

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(
                        CacheControl.maxAge(31536000, TimeUnit.MILLISECONDS)
                                .cachePublic()
                );
    }

    //@Override
    //public void addInterceptors(InterceptorRegistry registry) {
    //    super.addInterceptors(registry);
    //    registry.addInterceptor(new AuthInterceptor());
    //    registry.addInterceptor(new AuthorityByRole());
    //}

    /**
     * 配置项目启动加载的首页
     * @param registry
     */
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        //采用转发的方式
        //registry.addViewController( "/" ).setViewName( "forward:/home" );
        //直接返回页面的方式
        registry.addViewController( "/" ).setViewName( "index" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        //super.addViewControllers( registry );
    }
}
