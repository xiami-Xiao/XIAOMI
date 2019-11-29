package com.xiaomi.service.impl;

import com.xiaomi.dao.ProductDao;
import com.xiaomi.dao.impl.ProductDaoImpl;
import com.xiaomi.pojo.Product;
import com.xiaomi.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao dao = new ProductDaoImpl();

    @Override
    public Product findAllByPid(int pid) {
       Product product = dao.findAllByPid(pid);
        return product;
    }

    @Override
    public List<Product> findAllById() {
        return dao.findAllById();
    }
}
