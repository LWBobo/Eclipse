package com.chain.common.bean;


import java.util.List;

public class PaginationBean<T> {
    public final static int PAGE_SIZE = 5;

    private int pageSize = PAGE_SIZE;
    private List<T> items;
    private long totalCount;
    private int currentPage = 0;
    private int start;

    public PaginationBean() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public long getTotalPage() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public int getStartRecord() {
        return currentPage * pageSize;
    }
}
