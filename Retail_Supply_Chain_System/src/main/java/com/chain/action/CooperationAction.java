package com.chain.action;

import com.chain.common.bean.PaginationBean;
import com.chain.entity.CooperationEntity;
import com.chain.service.CooperationService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CooperationAction extends ActionSupport {

    @Autowired
    private CooperationService cooperationService;

    private PaginationBean<CooperationEntity> cooperationEntityPaginationBean;
    private CooperationEntity cooperationEntity;

    @SkipValidation
    public String list() {
        if (cooperationEntityPaginationBean == null) {
            cooperationEntityPaginationBean = new PaginationBean<CooperationEntity>();
        }
        cooperationEntityPaginationBean = cooperationService.pagedList(cooperationEntityPaginationBean);
        return SUCCESS;
    }

    @SkipValidation
    public String show() {
        cooperationEntity = cooperationService.getCooperationEntity(cooperationEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String add() {
        return SUCCESS;
    }

    @SkipValidation
    public String update() {
        cooperationEntity = cooperationService.getCooperationEntity(cooperationEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String delete() {
        cooperationService.delete(cooperationEntity);
        list();
        this.addActionMessage("删除成功！");
        return SUCCESS;
    }

    @Validations(
            requiredStrings = {
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "cooperationEntity.name", message = "公司名称必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "cooperationEntity.personInCharge", message = "负责人必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "cooperationEntity.telephone", message = "电话必须填写！", shortCircuit = true),
            }
    )
    public String save() {
        cooperationService.saveOrUpdateEntity(cooperationEntity);
        list();
        this.addActionMessage("操作成功！");
        return SUCCESS;
    }

    public PaginationBean<CooperationEntity> getCooperationEntityPaginationBean() {
        return cooperationEntityPaginationBean;
    }

    public void setCooperationEntityPaginationBean(PaginationBean<CooperationEntity> cooperationEntityPaginationBean) {
        this.cooperationEntityPaginationBean = cooperationEntityPaginationBean;
    }

    public CooperationEntity getCooperationEntity() {
        return cooperationEntity;
    }

    public void setCooperationEntity(CooperationEntity cooperationEntity) {
        this.cooperationEntity = cooperationEntity;
    }
}
