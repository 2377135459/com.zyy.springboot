package com.springboot.demo.mapper;

import com.springboot.demo.bean.UserLand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LandMapper {

    int insert(UserLand record);

    int insertSelective(UserLand record);

    UserLand selectByUsername(UserLand user);

    int updateByPrimaryKeySelective(UserLand record);

    int updateByPrimaryKey(UserLand record);

}
