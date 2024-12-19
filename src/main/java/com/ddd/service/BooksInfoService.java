package com.ddd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddd.pojo.BooksInfo;

public interface BooksInfoService extends IService<BooksInfo> {
    void removeArray(Long[] ids);
}
