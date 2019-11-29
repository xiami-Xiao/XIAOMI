package com.xiaomi.service;

import com.xiaomi.pojo.User;
import com.xiaomi.web.utils.ResultInfo;

public interface UserService {
    ResultInfo regedit(User user);
    ResultInfo login(User user);
}
