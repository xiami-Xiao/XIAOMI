package com.xiaomi.service;

import com.xiaomi.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllById();
    Product findAllByPid(int pid);
}
