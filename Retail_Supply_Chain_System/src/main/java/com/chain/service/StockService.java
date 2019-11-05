package com.chain.service;

import com.chain.common.bean.PaginationBean;
import com.chain.dao.BaseDAO;
import com.chain.entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("stockService")
public class StockService {

    @Autowired
    private BaseDAO<StockEntity> baseDAO;

    public List<StockEntity> list() {
        return baseDAO.list(StockEntity.class);
    }

    public PaginationBean<StockEntity> pagedList(PaginationBean<StockEntity> pagination) {
        return baseDAO.pagedList(StockEntity.class, pagination);
    }

    public void saveOrUpdateEntity(StockEntity stockEntity) {
        stockEntity.setUpdatedBy("SYSTEM");
        stockEntity.setUpdatedTs(new Timestamp(new Date().getTime()));
        if (stockEntity.getId() != null) {
            baseDAO.update(stockEntity);
        } else {
            stockEntity.setCreatedBy("SYSTEM");
            stockEntity.setCreatedTs(new Timestamp(new Date().getTime()));
            baseDAO.add(stockEntity);
        }
    }

    public StockEntity getStockEntity(StockEntity stockEntity) {
        return baseDAO.get(StockEntity.class, stockEntity.getId());
    }

    public StockEntity getStockEntity(Integer id) {
        return baseDAO.get(StockEntity.class, id);
    }
}
