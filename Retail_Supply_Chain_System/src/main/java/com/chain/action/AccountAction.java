package com.chain.action;

import com.chain.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AccountAction extends ActionSupport {

    @Autowired
    private AccountService accountService;

    private List<Object[]> top10BestSales;
    private List<Object[]> top10BestProducts;
    private List<Object[]> top10BestPurchases;


    public String show() {
        top10BestSales = accountService.top10BestSale();
        top10BestProducts = accountService.top10BestProduct();
        top10BestPurchases = accountService.top10BestPurchases();
        return SUCCESS;
    }

    public List<Object[]> getTop10BestSales() {
        return top10BestSales;
    }

    public void setTop10BestSales(List<Object[]> top10BestSales) {
        this.top10BestSales = top10BestSales;
    }

    public List<Object[]> getTop10BestProducts() {
        return top10BestProducts;
    }

    public void setTop10BestProducts(List<Object[]> top10BestProducts) {
        this.top10BestProducts = top10BestProducts;
    }

    public List<Object[]> getTop10BestPurchases() {
        return top10BestPurchases;
    }

    public void setTop10BestPurchases(List<Object[]> top10BestPurchases) {
        this.top10BestPurchases = top10BestPurchases;
    }
}
