package com.ddd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddd.mapper.AdminInfoMapper;
import com.ddd.pojo.AdminInfo;
import com.ddd.service.AdminInfoService;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements AdminInfoService {
}
