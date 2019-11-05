package com.chain.service;

import com.chain.common.bean.PaginationBean;
import com.chain.dao.BaseDAO;
import com.chain.entity.PurchaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service("purchaseService")
public class PurchaseService {

    @Autowired
    private BaseDAO<PurchaseEntity> baseDAO;

    public List<PurchaseEntity> list() {
        return baseDAO.list(PurchaseEntity.class);
    }

    public PaginationBean<PurchaseEntity> pagedList(PaginationBean<PurchaseEntity> pagination) {
        return baseDAO.pagedList(PurchaseEntity.class, pagination);
    }

    public void saveOrUpdateEntity(PurchaseEntity purchaseEntity) {
        purchaseEntity.setUpdatedBy("SYSTEM");
        purchaseEntity.setUpdatedTs(new Timestamp(new Date().getTime()));
        if (purchaseEntity.getId() != null) {
            baseDAO.update(purchaseEntity);
        } else {
            purchaseEntity.setCreatedBy("SYSTEM");
            purchaseEntity.setCreatedTs(new Timestamp(new Date().getTime()));
            baseDAO.add(purchaseEntity);
        }
    }

    public void delete(PurchaseEntity purchaseEntity) {
        purchaseEntity = baseDAO.get(PurchaseEntity.class, purchaseEntity.getId());
        if (purchaseEntity != null) {
            baseDAO.delete(purchaseEntity);
        }
    }

    public PurchaseEntity getPurchaseEntity(PurchaseEntity purchaseEntity) {
        return baseDAO.get(PurchaseEntity.class, purchaseEntity.getId());
    }

}
