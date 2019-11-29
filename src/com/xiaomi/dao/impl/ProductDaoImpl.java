package com.xiaomi.dao.impl;

import com.xiaomi.dao.ProductDao;
import com.xiaomi.dao.utils.JDBCUtils;
import com.xiaomi.pojo.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Product findAllByPid(int pid) {
        List<Product> lists = jt.query("select * from product where pid = ?", new BeanPropertyRowMapper<Product>(Product.class), pid);
        return lists.get(0);
    }


    @Override
    public List<Product> findAllById() {
        return jt.query("SELECT * FROM product", new BeanPropertyRowMapper<Product>(Product.class));
    }
}
