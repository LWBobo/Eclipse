package com.chain.action;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import com.chain.common.bean.PaginationBean;
import com.chain.entity.StockEntity;
import com.chain.service.StockService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StockAction extends ActionSupport {

    @Autowired
    private StockService stockService;

    private PaginationBean<StockEntity> stockEntityPaginationBean;
    private StockEntity stockEntity;

    @SkipValidation
    public String list() {
        if (stockEntityPaginationBean == null) {
            stockEntityPaginationBean = new PaginationBean<StockEntity>();
        }
        stockEntityPaginationBean = stockService.pagedList(stockEntityPaginationBean);
        int i=0;
        HttpServletRequest req=ServletActionContext.getRequest();
        req.setAttribute("dannum", i);
        return SUCCESS;
    }

    @SkipValidation
    public String show() {
        stockEntity = stockService.getStockEntity(stockEntity);
        return SUCCESS;
    }

    @SkipValidation
    public String add() {
        return SUCCESS;
    }

    @SkipValidation
    public String update() {
        stockEntity = stockService.getStockEntity(stockEntity);
        return SUCCESS;
    }

    @Validations(
            requiredStrings = {
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "stockEntity.product", message = "货物必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "stockEntity.place", message = "存放位置必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "stockEntity.status", message = "货物状态必须填写！", shortCircuit = true)
            },
            requiredFields = {
                    @RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "stockEntity.quantity", message = "数量必须填写！", shortCircuit = true),
                    @RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "stockEntity.danger", message = "预警库存量必须填写！", shortCircuit = true),
            }
    )
    public String save() {
        stockService.saveOrUpdateEntity(stockEntity);
        list();
        this.addActionMessage("操作成功！");
        return SUCCESS;
    }

    public PaginationBean<StockEntity> getStockEntityPaginationBean() {
        return stockEntityPaginationBean;
    }

    public void setStockEntityPaginationBean(PaginationBean<StockEntity> stockEntityPaginationBean) {
        this.stockEntityPaginationBean = stockEntityPaginationBean;
    }

    public StockEntity getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(StockEntity stockEntity) {
        this.stockEntity = stockEntity;
    }
}
