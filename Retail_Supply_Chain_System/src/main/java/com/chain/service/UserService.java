package com.chain.service;

import com.chain.common.bean.PaginationBean;
import com.chain.dao.BaseDAO;
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

@Service("userService")
public class UserService {

    @Autowired
    private BaseDAO<UserEntity> baseDAO;

    public List<UserEntity> list() {
        return baseDAO.list(UserEntity.class);
    }

    public PaginationBean<UserEntity> pagedList(PaginationBean<UserEntity> pagination) {
        return baseDAO.pagedList(UserEntity.class, pagination);
    }

    public void saveOrUpdateEntity(UserEntity userEntity) {
        userEntity.setUpdatedBy("SYSTEM");
        userEntity.setUpdatedTs(new Timestamp(new Date().getTime()));
        if (userEntity.getUserId() != null) {
            baseDAO.update(userEntity);
        } else {
            userEntity.setCreatedBy("SYSTEM");
            userEntity.setCreatedTs(new Timestamp(new Date().getTime()));
            userEntity.setPassword("123456");
            userEntity.setJoinedDate(new Date());
            baseDAO.add(userEntity);
        }
    }

    public void delete(UserEntity userEntity) {
        userEntity = baseDAO.get(UserEntity.class, userEntity.getUserId());
        if (userEntity != null) {
            baseDAO.delete(userEntity);
        }
    }

    public UserEntity getUserEntity(UserEntity userEntity) {
        return baseDAO.get(UserEntity.class, userEntity.getUserId());
    }

    public UserEntity getUserEntity(Integer id) {
        return baseDAO.get(UserEntity.class, id);
    }

    public void saveAvatar(UserEntity userEntity, File image, String imageFileName) throws IOException {
        if (image != null) {
            String path = "/images/" + UUID.randomUUID().toString() + imageFileName;
            File saveFile = new File(path);
            if (!saveFile.getParentFile().exists())
                saveFile.getParentFile().mkdirs();
            FileUtils.copyFile(image, saveFile);

            userEntity = getUserEntity(userEntity);
            userEntity.setAvatar(path);
            baseDAO.update(userEntity);
        }
    }

    public UserEntity getUserEntity(String username, String password) {
        String hql = "from UserEntity user where user.username = ? and user.password = ?";
        Object[] objects = new Object[]{username, password};
        List<UserEntity> userEntities = baseDAO.get(hql, objects);
        if (userEntities != null && userEntities.size() > 0) {
            return userEntities.get(0);
        }
        return null;
    }
}
