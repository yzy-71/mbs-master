package com.ddd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddd.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}