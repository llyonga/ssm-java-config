package com.io.ssm.framework.aspect;

import com.io.ssm.framework.annotation.ControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/11
 * @time: 22:21
 * @version: 1.0
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 本地异常日志记录对象
     */
    private  static  final Logger LOGGER = LoggerFactory.getLogger(LogAspect. class);

    /**
     * Service层切点
     */
    @Pointcut("@annotation(com.io.ssm.framework.annotation.ServiceLog)")
    public  void serviceAspect() {
    }

    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.io.ssm.framework.annotation.ControllerLog)")
    public  void controllerAspect() {
    }

//    @Before("controllerAspect()")
//    public  void doBefore(JoinPoint joinPoint) {
//        try {
//            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            //请求的IP
//            String ip = request.getRemoteAddr();
//            //需要转换成Json的HashMap
//            Map<String, Object> maps = new HashMap<String, Object>();
//            Map<String, String[]> parameterMap = request.getParameterMap();
//            maps.put("请求方法",joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
//            maps.put("请求描述",getControllerMethodDescription(joinPoint));
//            maps.put("请求IP",ip);
//            maps.put("data",parameterMap);
//            String jsonString = JSON.toJSONString(maps);
//            LOGGER.info(jsonString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog. class).description();
                    break;
                }
            }
        }
        return description;
    }

    @AfterReturning(value="controllerAspect()", returning="rtv")
    public  void doAfterReturning(JoinPoint joinPoint,Object rtv) {
        try {
            System.out.println("***************************切面打印******************************");
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //请求的IP
            String ip = request.getRemoteAddr();
            //需要转换成Json的HashMap
            Map<String, Object> maps = new HashMap<String, Object>();
            Map<String, String[]> parameterMap = request.getParameterMap();
            maps.put("请求方法",joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            maps.put("请求描述",getControllerMethodDescription(joinPoint));
            maps.put("请求IP",ip);
            maps.put("data",parameterMap);
            String jsonString = JSON.toJSONString(maps);
            LOGGER.info(jsonString);


            Signature signature = joinPoint.getSignature();
            System.out.println("DeclaringType:" + signature.getDeclaringType());
            System.out.println("DeclaringTypeName:" + signature.getDeclaringTypeName());
            System.out.println("Modifiers:" + signature.getModifiers());
            System.out.println("Name:" + signature.getName());
            System.out.println("LongString:" + signature.toLongString());
            System.out.println("ShortString:" + signature.toShortString());

            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                Object arg = joinPoint.getArgs()[i];
                if(null != arg) {
                    System.out.println("Args:" + arg.toString());
                }
            }

            System.out.println("Return:" + JSON.toJSONString(rtv));

            System.out.println("***************************切面打印******************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
