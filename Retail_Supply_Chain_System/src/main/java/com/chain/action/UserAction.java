package com.chain.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.chain.common.bean.PaginationBean;
import com.chain.entity.UserEntity;
import com.chain.service.UserService;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class UserAction extends ActionSupport {

    @Autowired
    private UserService userService;

    private PaginationBean<UserEntity> userEntityPaginationBean;
    private UserEntity userEntity;

    private File image;
    private String imageFileName;
    private String imageContentType;

    @SkipValidation
    public String list() {
        if (userEntityPaginationBean == null) {
            userEntityPaginationBean = new PaginationBean<UserEntity>();
        }
        userEntityPaginationBean = userService.pagedList(userEntityPaginationBean);
        return SUCCESS;
    }

    @SkipValidation
    public String show() {
        userEntity = userService.getUserEntity(userEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String add() {
        return SUCCESS;
    }

    @SkipValidation
    public String update() {
        userEntity = userService.getUserEntity(userEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String delete() {
    	try{
    		userService.delete(userEntity);
    		list();
    		this.addActionMessage("用户删除成功！");
    		return SUCCESS;
    		}
        catch(Exception e){
        	this.addActionMessage("删除失败，不能删除已登录用户！");
        	return SUCCESS;
        }
        
    }

    @Validations(
            requiredStrings = {
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "userEntity.username", message = "用户名必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "userEntity.name", message = "姓名必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "userEntity.sex", message = "性别必须填写！", shortCircuit = true),
            }
    )
    public String save() {
        try {
        	userService.saveOrUpdateEntity(userEntity);
        	list();
            this.addActionMessage("用户操作成功！");
            return SUCCESS;
		} catch (Exception e) {
			this.addFieldError("userEntity.username", "用户名已经存在！");
			return INPUT;
		}
        
    }

    @SkipValidation
    public String profile() {
        userEntity = userService.getUserEntity(userEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String upload() {
        try {
            userService.saveAvatar(userEntity, image, imageFileName);
            this.addActionMessage("头像上传成功！");
            return SUCCESS;
        } catch (IOException e) {
            return INPUT;
        }
    }

    public PaginationBean<UserEntity> getUserEntityPaginationBean() {
        return userEntityPaginationBean;
    }

    public void setUserEntityPaginationBean(PaginationBean<UserEntity> userEntityPaginationBean) {
        this.userEntityPaginationBean = userEntityPaginationBean;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
}
