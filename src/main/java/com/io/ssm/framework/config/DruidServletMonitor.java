package com.io.ssm.framework.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author lvyongb.
 * @Description Druid连接监控Servlet配置
 * @date 2018/4/27.
 */
@WebServlet(name="druidMonitor", urlPatterns="/druid/*", initParams={
        @WebInitParam(name="allow", value="127.0.0.1"),
        @WebInitParam(name="loginUsername", value="admin"),
        @WebInitParam(name="loginPassword", value="123456"),
        @WebInitParam(name="resetEnable", value="true")
})
public class DruidServletMonitor extends StatViewServlet {

}