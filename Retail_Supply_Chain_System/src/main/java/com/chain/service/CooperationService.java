package com.chain.service;

import com.chain.common.bean.PaginationBean;
import com.chain.dao.BaseDAO;
import com.chain.entity.CooperationEntity;
import com.chain.entity.UserEntity;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("cooperationService")
public class CooperationService {

    @Autowired
    private BaseDAO<CooperationEntity> baseDAO;

    public List<CooperationEntity> list() {
        return baseDAO.list(CooperationEntity.class);
    }

    public PaginationBean<CooperationEntity> pagedList(PaginationBean<CooperationEntity> pagination) {
        return baseDAO.pagedList(CooperationEntity.class, pagination);
    }

    public void saveOrUpdateEntity(CooperationEntity cooperationEntity) {
        cooperationEntity.setUpdatedBy("SYSTEM");
        cooperationEntity.setUpdatedTs(new Timestamp(new Date().getTime()));
        if (cooperationEntity.getId() != null) {
            baseDAO.update(cooperationEntity);
        } else {
            cooperationEntity.setCreatedBy("SYSTEM");
            cooperationEntity.setCreatedTs(new Timestamp(new Date().getTime()));
            baseDAO.add(cooperationEntity);
        }
    }

    public void delete(CooperationEntity cooperationEntity) {
        cooperationEntity = baseDAO.get(CooperationEntity.class, cooperationEntity.getId());
        if (cooperationEntity != null) {
            baseDAO.delete(cooperationEntity);
        }
    }

    public CooperationEntity getCooperationEntity(CooperationEntity cooperationEntity) {
        return baseDAO.get(CooperationEntity.class, cooperationEntity.getId());
    }

    public CooperationEntity getCooperationEntity(Integer id) {
        return baseDAO.get(CooperationEntity.class, id);
    }
}
