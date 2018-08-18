package com.io.ssm.module.service.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/9
 * @time: 23:17
 * @version: 1.0
 */
public class PageListDto<T> implements Serializable {

    private Long total;
    private List<T> rows;

    public PageListDto(Long total, List<T> rows) {
        this.total = total;
        if (rows == null) {
            rows = new ArrayList();
        }

        this.rows = (List) rows;
    }

    public PageListDto() {
        this.total = 0L;
        this.setRows(new ArrayList());
    }

    public PageListDto(List<T> list) {
        if (list == null) {
            this.total = 0L;
            this.setRows(new ArrayList());
        } else {
            this.setRows(list);
            this.total = (long) list.size();
        }

    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        if (total != null) {
            this.total = total;
        } else {
            this.total = 0L;
        }

    }

    public void setTotal(Integer total) {
        if (total != null) {
            this.total = total.longValue();
        } else {
            this.total = 0L;
        }

    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
