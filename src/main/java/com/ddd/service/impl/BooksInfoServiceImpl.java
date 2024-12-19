package com.ddd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddd.common.CustomException;
import com.ddd.mapper.BooksInfoMapper;
import com.ddd.pojo.BooksInfo;
import com.ddd.service.BooksInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BooksInfoServiceImpl extends ServiceImpl<BooksInfoMapper, BooksInfo>  implements BooksInfoService {

    @Override
    @Transactional
    public void removeArray(Long[] bids) {
        for (Long id : bids) {
            BooksInfo booksInfo = this.getById(id);
            Integer status = booksInfo.getStatus();
            if (status != 2){
                throw  new CustomException("该书籍:{ "+booksInfo.getName()+" }正在借阅，无法删除");
            }

            this.removeById(id);
        }
    }
}
