package com.springboot.demo.mapper;

import com.springboot.demo.bean.UserBaseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserBaseInfoMapper {

    List<UserBaseInfo> selectByPrimaryKey(Long landId);

    int insert(UserBaseInfo record);

    UserBaseInfo deleteByPrimaryKey(Long id);

    int insertSelective(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);

    int updateByPrimaryKeySelective(Long id);
}
