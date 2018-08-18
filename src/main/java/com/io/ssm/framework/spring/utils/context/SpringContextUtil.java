package com.io.ssm.framework.spring.utils.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SpringContextUtil 以静态变量保存 Spring ApplicationContext, 可在任何代码任何地方任何时候中取出
 * ApplicaitonContext.
 *
 * @author lvyong
 * @version 2017-07-19 下午6:46:43
 * @date 2017年7月19日
 */
public class SpringContextUtil implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    private static Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);

    /**
     * 实现 ApplicationContextAware 接口, 注入Context到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        logger.debug("注入 ApplicationContext 到 SpringContextUtil:" + applicationContext);

        if (SpringContextUtil.applicationContext != null) {
            logger.warn("SpringContextUtil 中的 ApplicationContext 被覆盖, 原有 ApplicationContext 为:" + SpringContextUtil.applicationContext);
        }
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 取得存储在静态变量中的 ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    /**
     * 从静态变量 applicationContext 中取得 Bean, 自动转型为所赋值对象的类型.
     *
     * @param <T>
     * @param name - Bean's name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量 applicationContext 中取得 Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 清除 SpringContextUtil 中的 ApplicationContext 为 Null.
     */
    public static void clear() {
        logger.debug("清除 SpringContextUtil 中的 ApplicationContext:" + applicationContext);
        applicationContext = null;
    }

    /**
     * 实现 DisposableBean 接口,在 Context 关闭时清理静态变量.
     */
    @Override
    public void destroy() throws Exception {
        SpringContextUtil.clear();
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext 未注入,请在 applicationContext.xml 中定义 SpringContextUtil");
        }
    }

}
