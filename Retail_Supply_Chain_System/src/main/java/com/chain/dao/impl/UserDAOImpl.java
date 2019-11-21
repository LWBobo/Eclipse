package com.chain.dao.impl;

import com.chain.dao.UserDAO;
import com.chain.entity.UserEntity;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {

    public List<Object[]> top10BestSale() {
        HibernateTemplate tmpl = getHibernateTemplate();
        return tmpl.execute(new HibernateCallback<List<Object[]>>() {
            @SuppressWarnings("unchecked")
            
            public List<Object[]> doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery("select t1.real_name, sum(t2.amount) total_amount from tb_chain_user t1 " +
                        "left join tb_chain_sale t2 on t1.USER_ID = t2.user_id " +
                        "group by t1.real_name " +
                        "order by total_amount desc " +
                        "limit 0, 10");
                List results = query.list();
                return (List<Object[]>)results;
            }
        });
    }

     
    public List<Object[]> top10BestPurchases() {
        HibernateTemplate tmpl = getHibernateTemplate();
        return tmpl.execute(new HibernateCallback<List<Object[]>>() {
            @SuppressWarnings("unchecked")
            public List<Object[]> doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery("select t1.real_name, sum(t2.amount) total_amount from tb_chain_user t1 " +
                        "left join tb_chain_purchase t2 on t1.USER_ID = t2.user_id " +
                        "group by t1.real_name " +
                        "order by total_amount desc " +
                        "limit 0, 10");
                List results = query.list();
                return (List<Object[]>)results;
            }
        });
    }

    
    public List<Object[]> top10BestProduct() {
        HibernateTemplate tmpl = getHibernateTemplate();
        return tmpl.execute(new HibernateCallback<List<Object[]>>() {
            @SuppressWarnings("unchecked")
             
            public List<Object[]> doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery("select t1.`product`, sum(t2.`QUANTITY`) total_quantity from tb_chain_stock t1 " +
                        "left join tb_chain_sale t2 on t1.`COO_ID` = t2.stock_id " +
                        "group by t1.product " +
                        "order by total_quantity desc");
                List results = query.list();
                return (List<Object[]>)results;
            }
        });
    }



}
