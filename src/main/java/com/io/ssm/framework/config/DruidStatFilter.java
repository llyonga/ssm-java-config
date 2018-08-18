package com.io.ssm.framework.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author lvyongb.
 * @Description  Druid连接监控Filter配置
 * @date 2018/4/27.
 */
@WebFilter(filterName="druidFilter", urlPatterns="/*", initParams={
        @WebInitParam(name="exclusions", value="*.js,*.gif,*.jpg,*.png,*.css,*.ico,.html,/druid/*,/download/*")
})
public class DruidStatFilter extends WebStatFilter {

}
