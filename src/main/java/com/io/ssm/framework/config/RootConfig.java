package com.io.ssm.framework.config;

import com.io.ssm.framework.spring.utils.context.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lvyongb.
 * @Description spring 容器配置
 * @date 2018/4/26.
 */
//@EnableAspectJAutoProxy等同<aop:aspectj-autoproxy/>
//    <!--通知spring使用cglib而不是jdk的来生成代理方法 AOP可以拦截到Controller-->
//    <aop:aspectj-autoproxy proxy-target-class="true" />
// 开启基于注解的AOP模式
@Configuration
@EnableAspectJAutoProxy
@Import({DruidDataSourceConfiguration.class})
@ComponentScan(basePackages = {"com.io.ssm.module"},
        //不扫描以下包
        excludeFilters =
                {@ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = {EnableWebMvc.class, ControllerAdvice.class, Controller.class})})
public class RootConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RootConfig.class);

    @Bean
    public BeanNameAutoProxyCreator proxyCreator(){
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        proxyCreator.setBeanNames("*Service");
        proxyCreator.setInterceptorNames("transactionInterceptor");
        return proxyCreator;
    }

    @Bean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }
}