package com.io.ssm.framework.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/11
 * @time: 22:46
 * @version: 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog{
    String description()  default "";
}
