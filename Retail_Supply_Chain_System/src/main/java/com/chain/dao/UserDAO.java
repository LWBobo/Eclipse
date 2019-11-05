package com.chain.dao;


import com.chain.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    public List<Object[]> top10BestSale();

    public List<Object[]> top10BestPurchases();

    public List<Object[]> top10BestProduct();

}
