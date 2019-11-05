package com.chain.service;


import com.chain.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private UserDAO userDAO;

    public List<Object[]> top10BestSale() {
        return userDAO.top10BestSale();
    }

    public List<Object[]> top10BestPurchases() {
        return userDAO.top10BestPurchases();
    }

    public List<Object[]> top10BestProduct() {
        return userDAO.top10BestProduct();
    }

}
