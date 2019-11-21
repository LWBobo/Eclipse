package com.chain.dao.impl;

import com.chain.common.bean.PaginationBean;
import com.chain.dao.BaseDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Component("baseDAO")
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

    private static final Log log = LogFactory.getLog(BaseDAOImpl.class);

    @Resource(name = "sessionFactory")
    public void setBaseDaoSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void add(T t) {
        try {
            super.getHibernateTemplate().persist(t);
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void delete(T t) {
        try {
            super.getHibernateTemplate().delete(t);
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void update(T t) {
        try {
            super.getHibernateTemplate().update(t);
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public List<T> list(Class<T> clazz) {
        try {
            return super.getHibernateTemplate().loadAll(clazz);
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    
    public T get(Class<T> clazz, Serializable id) {
        try {
            return super.getHibernateTemplate().get(clazz, id);
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

     
    public List<T> get(String hql, Object[] objects) {
        try {
            return super.getHibernateTemplate().find(hql, objects);
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

     
    public PaginationBean<T> pagedList(final Class<T> clazz, final PaginationBean<T> paginationBean) {
        return (PaginationBean<T>) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(clazz);
                long totalCount = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).longValue();
                criteria.setProjection(null);
                List<T> items = criteria.setFirstResult(paginationBean.getStartRecord()).setMaxResults(paginationBean.getPageSize()).list();
                paginationBean.setItems(items);
                paginationBean.setTotalCount(totalCount);
                return paginationBean;
            }
        });
    }
}
