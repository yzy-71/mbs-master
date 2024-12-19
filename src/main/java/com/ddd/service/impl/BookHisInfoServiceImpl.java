package com.ddd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddd.mapper.BookHisInfoMapper;
import com.ddd.pojo.BookHisInfo;
import com.ddd.service.BookHisInfoService;
import org.springframework.stereotype.Service;

@Service
public class BookHisInfoServiceImpl extends ServiceImpl<BookHisInfoMapper, BookHisInfo> implements BookHisInfoService {
}
