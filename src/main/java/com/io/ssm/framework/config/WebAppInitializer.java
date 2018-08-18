package com.io.ssm.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author lvyongb.
 * @Description 项目启动初始化类  相当于web.xml
 * @date 2018/4/26.
 *
 * AbstractAnnotationConfigDispatcherServletInitializer这个类负责配置DispatcherServlet、初始化Spring MVC容器和Spring容器。
 * getRootConfigClasses()方法用于获取Spring应用容器的配置文件，这里我们给定预先定义的RootConfig.class；getServletConfigClasses
 * 负责获取Spring MVC应用容器，这里传入预先定义好的WebConfig.class；getServletMappings()方法负责指定需要由DispatcherServlet
 * 映射的路径，这里给定的是"/"，意思是由DispatcherServlet处理所有向该应用发起的请求。
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);

    /**
     * spring 根容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        LOG.info("------root配置类初始化------");
        return new Class<?>[] {RootConfig.class};
    }

    /**
     * Spring mvc容器
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        LOG.info("------web配置类初始化------");
        return new Class<?>[] {WebMvcConfig.class};
    }

    /**
     * DispatcherServlet映射,从"/"开始
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        LOG.info("------映射根路径初始化------");
        return new String[] {"/"};
    }

    //@Override
    //protected Filter[] getServletFilters() {
    //    return new Filter[] {new TestFilter()};
    //}

    /**
     * 在DispatcherServlet中指定Multipart的配置,用于文件上传
     */
    //@Override
    //protected void customizeRegistration(Dynamic registration) {
    //    registration.setMultipartConfig(new MultipartConfigElement(""));
    //}

}