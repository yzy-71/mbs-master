package com.ddd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddd.common.R;
import com.ddd.pojo.BookTypeInfo;
import com.ddd.service.BookTypeInfoService;
import com.ddd.service.BooksInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookTypeInfoController {
    @Autowired
    private BookTypeInfoService bookTypeInfoService;

    @Autowired
    private  BooksInfoService booksInfoService;

    /*
    获取和搜索书籍分类信息
     */
    @RequestMapping("/page")
    public R<Page<BookTypeInfo>> page(Integer page,Integer pageSize,String name){
        log.info("page={}",page);
        log.info("pageSize={}",pageSize);
        Page<BookTypeInfo> bookTypeInfoPage = new Page<>(page,pageSize);

        LambdaQueryWrapper<BookTypeInfo> lambdaQueryWrapper = new LambdaQueryWrapper<BookTypeInfo>();

        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name),BookTypeInfo::getName,name);


        //根据条件查询封装
        bookTypeInfoService.page(bookTypeInfoPage,lambdaQueryWrapper);

        return R.success(bookTypeInfoPage);

    }
    /*
    删除分类
     */
    @DeleteMapping("/{id}")
    public R<String> delete(@PathVariable Integer id){
        log.info("id={}",id);
        R<String> r = bookTypeInfoService.deleteByid(id);
        return  r;
    }
    /*
    添加分类
     */

    @PostMapping
    public  R<String> save(@RequestBody BookTypeInfo bookTypeInfo){
        bookTypeInfoService.save(bookTypeInfo);
            return R.success("添加成功");
    }

    @DeleteMapping("/batchDelete")
    public R<String> batchDelete( Long[] tids){
        bookTypeInfoService.removeArray(tids);

        return R.success("删除成功");
    }

    /*
    修改书籍分类，并且对该分类下的书籍的type 分类信息进行同步
     */
    @PutMapping
    public R<String> put( BookTypeInfo classData){

       bookTypeInfoService.putWithBook(classData);

        return R.success("修改成功");
    }


    /*
    获取分类信息
     */
    @RequestMapping("/book_categories")
    public R<List<BookTypeInfo>> bookCategories(){
        List<BookTypeInfo> list = bookTypeInfoService.list();
        return  R.success(list);
    }
}
