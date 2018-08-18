package com.io.ssm.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @author lvyongb.
 * @Description thymeleaf模板配置
 * @date 2018/4/26.
 *
 * ps：这里需要ApplicationContext
 * 解决方法2种：
 * 1、实现ApplicationContextAware接口，重写setApplicationContext方法
 * 2、ITemplateResolver templateResolver（）定义为一个bean
 */
@Configuration
public class ThymeleafConfig /*implements ApplicationContextAware*/ {

    private static final Logger LOG = LoggerFactory.getLogger(ThymeleafConfig.class);

    /*private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }*/

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        // 设置编码，否则中文乱码
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        //resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:templates/");
        resolver.setSuffix(".html");
        //默认是TemplateMode.HTML
        resolver.setTemplateMode(TemplateMode.HTML);
        // 设置编码，否则中文乱码
        resolver.setCharacterEncoding("UTF-8");
        //设置缓存，默认是true
        resolver.setCacheable(false);
        return resolver;
    }

}
