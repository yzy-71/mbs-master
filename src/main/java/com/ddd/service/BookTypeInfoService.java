package com.ddd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddd.common.R;
import com.ddd.pojo.BookTypeInfo;

public interface BookTypeInfoService extends IService<BookTypeInfo> {
    R<String> deleteByid(Integer id);

    void removeArray(Long[] tids);

    void putWithBook(BookTypeInfo classData);
}
