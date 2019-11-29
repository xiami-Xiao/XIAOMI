package com.xiaomi.dao.impl;

import com.xiaomi.dao.UserDao;
import com.xiaomi.dao.utils.JDBCUtils;
import com.xiaomi.pojo.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByName(User user) {
            User u = null;
            int len =jt.queryForObject("SELECT count(*) FROM USER WHERE NAME=?", Integer.class, user.getUsername());
            if (len > 0 ){
                u = new User();
            }
        return u;
    }

    @Override
    public String findUserNameByNameAndPwd(User user) {
        String name = null;
        try {
            name = jt.queryForObject("select name from user where name = ? and password = ?", String.class, user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {

        }
        return name;
    }

    @Override
    public int saveUser(User user) {
        return  jt.update("INSERT INTO USER VALUES(null,?,?,?,NULL,NULL)", user.getUsername(), user.getPassword(), user.getTel());
    }
}
