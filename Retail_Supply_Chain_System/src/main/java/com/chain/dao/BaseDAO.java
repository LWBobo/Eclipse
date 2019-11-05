package com.chain.dao;


import com.chain.common.bean.PaginationBean;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

    public void add(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> list(Class<T> clazz);

    public T get(Class<T> clazz, Serializable id);

    public List<T> get(String hql, Object[] objects);

    public PaginationBean<T> pagedList(final Class<T> clazz, final PaginationBean<T> paginationBean);

}
