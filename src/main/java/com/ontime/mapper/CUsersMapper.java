package com.ontime.mapper;

import com.ontime.pojo.CUsers;
import com.ontime.pojo.CUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repositorypublic interface CUsersMapper {
    int countByExample(CUsersExample example);

    int deleteByExample(CUsersExample example);

    int deleteByPrimaryKey(Integer cuId);

    int insert(CUsers record);

    int insertSelective(CUsers record);

    List<CUsers> selectByExample(CUsersExample example);

    CUsers selectByPrimaryKey(Integer cuId);

    int updateByExampleSelective(@Param("record") CUsers record, @Param("example") CUsersExample example);

    int updateByExample(@Param("record") CUsers record, @Param("example") CUsersExample example);

    int updateByPrimaryKeySelective(CUsers record);

    int updateByPrimaryKey(CUsers record);
}
