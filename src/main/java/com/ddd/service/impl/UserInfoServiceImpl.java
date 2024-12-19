package com.ddd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddd.mapper.UserInfoMapper;
import com.ddd.pojo.UserInfo;
import com.ddd.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>  implements UserInfoService {

    @Override
    @Transactional
    public void deleteArray(Long[] aids) {
        for (Long aid : aids) {
            this.removeById(aid);
        }
    }
}
