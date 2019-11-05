package com.chain.service;

import com.chain.common.bean.PaginationBean;
import com.chain.dao.BaseDAO;
import com.chain.entity.PurchaseEntity;
import com.chain.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("saleService")
public class SaleService {

    @Autowired
    private BaseDAO<SaleEntity> baseDAO;

    public List<SaleEntity> list() {
        return baseDAO.list(SaleEntity.class);
    }

    public PaginationBean<SaleEntity> pagedList(PaginationBean<SaleEntity> pagination) {
        return baseDAO.pagedList(SaleEntity.class, pagination);
    }

    public void saveOrUpdateEntity(SaleEntity saleEntity) {
        saleEntity.setUpdatedBy("SYSTEM");
        saleEntity.setUpdatedTs(new Timestamp(new Date().getTime()));
        if (saleEntity.getId() != null) {
            baseDAO.update(saleEntity);
        } else {
            saleEntity.setCreatedBy("SYSTEM");
            saleEntity.setCreatedTs(new Timestamp(new Date().getTime()));
            baseDAO.add(saleEntity);
        }
    }

    public void delete(SaleEntity saleEntity) {
        saleEntity = baseDAO.get(SaleEntity.class, saleEntity.getId());
        if (saleEntity != null) {
            baseDAO.delete(saleEntity);
        }
    }

    public SaleEntity getSaleEntity(SaleEntity saleEntity) {
        return baseDAO.get(SaleEntity.class, saleEntity.getId());
    }

}
