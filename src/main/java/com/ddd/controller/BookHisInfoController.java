package com.ddd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddd.common.R;
import com.ddd.pojo.BookHisInfo;
import com.ddd.pojo.BooksInfo;
import com.ddd.pojo.UserInfo;
import com.ddd.service.BookHisInfoService;
import com.ddd.service.BooksInfoService;
import com.ddd.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequestMapping("/book_his")
public class BookHisInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private BooksInfoService booksInfoService;


    @Autowired
    private BookHisInfoService bookHisInfoService;

    @PostMapping
    public R<String> borrowBook(@RequestBody BookHisInfo bookHisInfo, HttpServletRequest httpServletRequest) {
        //获取用户信息

        String username = (String) httpServletRequest.getSession().getAttribute("user");

        LambdaQueryWrapper<UserInfo> userInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userInfoLambdaQueryWrapper.eq(UserInfo::getUsername, username);

        UserInfo userInfo = userInfoService.getOne(userInfoLambdaQueryWrapper);

        bookHisInfo.setAid(userInfo.getAid());
        bookHisInfo.setAdminName(userInfo.getUsername());
        bookHisInfo.setUsername(userInfo.getName());
        bookHisInfo.setStatus(1);

        String bid = bookHisInfo.getBid();

        BooksInfo booksInfo = booksInfoService.getById(bid);

        booksInfo.setStatus(1);

        booksInfoService.updateById(booksInfo);

        bookHisInfoService.save(bookHisInfo);

        return R.success("借阅成功");
    }

    @GetMapping("/page")
    public R<Page<BookHisInfo>> page(Integer page, Integer pageSize, String name, String card,HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("users");

        Page<BookHisInfo> page1 = new Page<>(page, pageSize);
        LambdaQueryWrapper<BookHisInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name), BookHisInfo::getBookName, name);
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(card), BookHisInfo::getCard, card);
        lambdaQueryWrapper.eq(BookHisInfo::getStatus, 1);
        lambdaQueryWrapper.eq(BookHisInfo::getAid,user.getAid());

        bookHisInfoService.page(page1, lambdaQueryWrapper);
        return R.success(page1);

    }

    @GetMapping
    public R<String> returnBook(String hid) {
        LambdaQueryWrapper<BookHisInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BookHisInfo::getHid, hid);

        BookHisInfo bookHisInfo = bookHisInfoService.getOne(lambdaQueryWrapper);

        bookHisInfo.setStatus(2);

        bookHisInfoService.updateById(bookHisInfo);

        //还要更新书籍信息表

        BooksInfo booksInfo = booksInfoService.getById(bookHisInfo.getBid());
        booksInfo.setStatus(2);

        booksInfoService.updateById(booksInfo);


        return R.success("还书成功");

    }

    @GetMapping("/his")
    public R<Page<BookHisInfo>> his(Integer page, Integer pageSize) {
        Page<BookHisInfo> bookHisInfoPage = new Page<>(page, pageSize);

        bookHisInfoService.page(bookHisInfoPage);


        return R.success(bookHisInfoPage);

    }

    @DeleteMapping("/{tid}")
    public R<String> delete(@PathVariable("tid") Integer hid) {
        bookHisInfoService.removeById(hid);
        return R.success("删除成功");
    }

    //    his_admin
    @GetMapping("/his_admin")
    public R<Page<BookHisInfo>> hisAdmin(Integer page, Integer pageSize, String name, String card,String adminName,String username) {
        Page<BookHisInfo> page1 = new Page<>(page, pageSize);
        LambdaQueryWrapper<BookHisInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name), BookHisInfo::getBookName, name);
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(card), BookHisInfo::getCard, card);
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(adminName), BookHisInfo::getAdminName, adminName);
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(username), BookHisInfo::getUsername, username);
        lambdaQueryWrapper.eq(BookHisInfo::getStatus, 2);

        bookHisInfoService.page(page1, lambdaQueryWrapper);
        return R.success(page1);

    }
}
