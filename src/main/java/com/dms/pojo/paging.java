package com.dms.pojo;

public class paging {
    private Integer page = 1;//当前页码数
    private Integer rows=10;//显示条数

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
