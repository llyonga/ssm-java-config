package com.io.ssm.module.web.common;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import com.io.ssm.framework.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/9
 * @time: 14:46
 * @version: 1.0
 */
public class BaseController {

    @Autowired
    public HttpServletRequest request;


    /**
     * 获取分页参数
     *
     * @return
     */
    public RowBounds getRowBounds() {

        //页码
        Integer pageNumber = 0;
        if (!StringUtils.isEmpty(request.getParameter("pageNumber"))) {
            pageNumber = NumberUtils.parseNumber(request.getParameter("pageNumber"), Integer.class);
        }

        //页面大小
        Integer pageSize = 100000;
        if (!StringUtils.isEmpty(request.getParameter("pageSize"))) {
            pageSize = NumberUtils.parseNumber(request.getParameter("pageSize"), Integer.class);
        }
        pageSize = pageSize > 0 ? pageSize : 10;
        RowBounds rowBounds = new RowBounds(pageNumber,pageSize);
        return rowBounds;
    }

    /**
     * 获取排序条件
     * @return
     */
    public String getOrderBy() {
        String orderBy = "";
        if (!StringUtils.isEmpty(request.getParameter("sortName"))) {
            orderBy = orderBy + StringUtils.HumpToUnderline(request.getParameter("sortName")) + "  " + request.getParameter("sortOrder");
        }
        return orderBy;
    }
}
