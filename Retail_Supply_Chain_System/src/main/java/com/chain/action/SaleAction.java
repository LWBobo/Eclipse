package com.chain.action;

import com.chain.common.bean.PaginationBean;
import com.chain.entity.*;
import com.chain.service.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleAction extends ActionSupport implements Preparable {

    @Autowired
    private SaleService saleService;
    @Autowired
    private UserService userService;
    @Autowired
    private StockService stockService;

    private PaginationBean<SaleEntity> saleEntityPaginationBean;
    private SaleEntity saleEntity;

    private String user;
    private String stock;

    private List<UserEntity> userEntityList;
    private List<StockEntity> stockEntityList;

    @SkipValidation
    public String list() {
        if (saleEntityPaginationBean == null) {
            saleEntityPaginationBean = new PaginationBean<SaleEntity>();
        }
        saleEntityPaginationBean = saleService.pagedList(saleEntityPaginationBean);
        return SUCCESS;
    }

    @SkipValidation
    public String add() {
        return SUCCESS;
    }

    @Validations(
            requiredStrings = {
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user", message = "销售人员必须填写！", shortCircuit = true),
                    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "stock", message = "销售产品必须填写！", shortCircuit = true),
            },
            requiredFields = {
                    @RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "saleEntity.quantity", message = "总数量必须填写！", shortCircuit = true),
                    @RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "saleEntity.amount", message = "总金额必须填写！", shortCircuit = true)
            }
    )
    public String save() {
        StockEntity stockEntity = stockService.getStockEntity(Integer.valueOf(stock));
        if (stockEntity.getQuantity() < saleEntity.getQuantity()) {
            this.addFieldError("saleEntity.quantity", "库存不足，请重新填写");
            return INPUT;
        }

        saleEntity.setUserEntity(userService.getUserEntity(Integer.valueOf(user)));
        saleEntity.setStockEntity(stockEntity);
        saleService.saveOrUpdateEntity(saleEntity);

        stockEntity.setQuantity(stockEntity.getQuantity() - saleEntity.getQuantity());
        stockService.saveOrUpdateEntity(stockEntity);

        list();
        this.addActionMessage("操作成功！");
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        userEntityList = userService.list();
        stockEntityList = stockService.list();
    }

    public PaginationBean<SaleEntity> getSaleEntityPaginationBean() {
        return saleEntityPaginationBean;
    }

    public void setSaleEntityPaginationBean(PaginationBean<SaleEntity> saleEntityPaginationBean) {
        this.saleEntityPaginationBean = saleEntityPaginationBean;
    }

    public SaleEntity getSaleEntity() {
        return saleEntity;
    }

    public void setSaleEntity(SaleEntity saleEntity) {
        this.saleEntity = saleEntity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public List<StockEntity> getStockEntityList() {
        return stockEntityList;
    }

    public void setStockEntityList(List<StockEntity> stockEntityList) {
        this.stockEntityList = stockEntityList;
    }
}
