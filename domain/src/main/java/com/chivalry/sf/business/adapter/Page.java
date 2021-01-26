package com.chivalry.sf.business.adapter;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private List<T> list;
    private long total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
