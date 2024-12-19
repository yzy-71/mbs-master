package com.ddd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddd.pojo.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    void deleteArray(Long[] aids);
}
