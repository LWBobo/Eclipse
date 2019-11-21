package com.chain.action;

import com.chain.common.bean.PaginationBean;
import com.chain.entity.CooperationEntity;
import com.chain.entity.PurchaseEntity;
import com.chain.entity.UserEntity;
import com.chain.service.CooperationService;
import com.chain.service.PurchaseService;
import com.chain.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.List;

@Component
public class PurchaseAction extends ActionSupport implements Preparable {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private UserService userService;
    @Autowired
    private CooperationService cooperationService;

    private PaginationBean<PurchaseEntity> purchaseEntityPaginationBean;
    private PurchaseEntity purchaseEntity;

    private String user;
    private String cooperation;

    private List<UserEntity> userEntityList;
    private List<CooperationEntity> cooperationEntityList;

    @SkipValidation
    public String list() {
        if (purchaseEntityPaginationBean == null) {
            purchaseEntityPaginationBean = new PaginationBean<PurchaseEntity>();
        }
        purchaseEntityPaginationBean = purchaseService.pagedList(purchaseEntityPaginationBean);
        return SUCCESS;
    }

    @SkipValidation
    public String show() {
        purchaseEntity = purchaseService.getPurchaseEntity(purchaseEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String add() {
        return SUCCESS;
    }

    @SkipValidation
    public String update() {
        purchaseEntity = purchaseService.getPurchaseEntity(purchaseEntity);
//        user = String.valueOf(purchaseEntity.getUserEntity().getUserId());
        cooperation = String.valueOf(purchaseEntity.getCooperationEntity().getId());
        return SUCCESS;
    }

    @SkipValidation
    public String delete() {
        purchaseService.delete(purchaseEntity);
        list();
        this.addActionMessage("删除成功！");
        return SUCCESS;
    }

    @Validations(
            requiredStrings = {
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user", message = "采购人员必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "cooperation", message = "采购公司必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "purchaseEntity.product", message = "采购商品必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "purchaseEntity.transport", message = "运送方式必须填写！", shortCircuit = true)
            },
            requiredFields = {
                    @RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "purchaseEntity.quantity", message = "总数量必须填写！", shortCircuit = true),
                    @RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "purchaseEntity.amount", message = "总金额必须填写！", shortCircuit = true)
            }
    )
    public String save() {
        purchaseEntity.setUserEntity(userService.getUserEntity(Integer.valueOf(user)));
        purchaseEntity.setCooperationEntity(cooperationService.getCooperationEntity(Integer.valueOf(cooperation)));
        purchaseService.saveOrUpdateEntity(purchaseEntity);
        list();
        this.addActionMessage("操作成功！");
        return SUCCESS;
    }

    public PaginationBean<PurchaseEntity> getPurchaseEntityPaginationBean() {
        return purchaseEntityPaginationBean;
    }

    public void setPurchaseEntityPaginationBean(PaginationBean<PurchaseEntity> purchaseEntityPaginationBean) {
        this.purchaseEntityPaginationBean = purchaseEntityPaginationBean;
    }

    public PurchaseEntity getPurchaseEntity() {
        return purchaseEntity;
    }

    public void setPurchaseEntity(PurchaseEntity purchaseEntity) {
        this.purchaseEntity = purchaseEntity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public List<CooperationEntity> getCooperationEntityList() {
        return cooperationEntityList;
    }

    public void setCooperationEntityList(List<CooperationEntity> cooperationEntityList) {
        this.cooperationEntityList = cooperationEntityList;
    }

    public void prepare() throws Exception {
        userEntityList = userService.list();
        cooperationEntityList = cooperationService.list();
    }
}
