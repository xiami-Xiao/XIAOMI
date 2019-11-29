package com.xiaomi.dao;

import com.xiaomi.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查找用户
     * @param user
     * @return
     */
    User findUserByName(User user);

    /**
     * 根据用户名和密码查找用户名
     * @param user
     * @return
     */
    String findUserNameByNameAndPwd(User user);
    int saveUser(User user);
}
