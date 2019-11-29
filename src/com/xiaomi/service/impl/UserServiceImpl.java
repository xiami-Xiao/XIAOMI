package com.xiaomi.service.impl;

import com.xiaomi.dao.UserDao;
import com.xiaomi.dao.impl.UserDaoImpl;
import com.xiaomi.pojo.User;
import com.xiaomi.service.UserService;
import com.xiaomi.web.utils.ResultInfo;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public ResultInfo login(User user) {
        ResultInfo info = new ResultInfo();
        String name = dao.findUserNameByNameAndPwd(user);
        if (name ==null){
            info.setFlag(false);
            info.setMsg("用户民或者密码错误！");
        }else {
            info.setFlag(true);
            info.setData(name);
        }
        return info;
    }

    @Override
    public ResultInfo regedit(User user) {
        ResultInfo info = new ResultInfo();
        User u = dao.findUserByName(user);
        if (u != null){
            //查询到重复用户
            info.setFlag(false);
            info.setData(u);
            info.setMsg("用户名已存在！");
        }else {
            //没有查询到用户，保存添加用户
           int len =  dao.saveUser(user);
           if (len > 0 ){
               info.setFlag(true);
           }else {
               info.setFlag(false);
               info.setMsg("对不起，注册失败，请联系管理员！");
           }
        }
        return info;
    }
}
