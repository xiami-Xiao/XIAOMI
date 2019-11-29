package com.xiaomi.dao;

import com.xiaomi.pojo.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllById();

    Product findAllByPid(int pid);
}
