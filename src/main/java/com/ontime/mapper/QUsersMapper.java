package com.ontime.mapper;

import com.ontime.pojo.QUsers;
import com.ontime.pojo.QUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QUsersMapper {
    int countByExample(QUsersExample example);

    int deleteByExample(QUsersExample example);

    int deleteByPrimaryKey(Integer quId);

    int insert(QUsers record);

    int insertSelective(QUsers record);

    List<QUsers> selectByExample(QUsersExample example);

    QUsers selectByPrimaryKey(Integer quId);

    int updateByExampleSelective(@Param("record") QUsers record, @Param("example") QUsersExample example);

    int updateByExample(@Param("record") QUsers record, @Param("example") QUsersExample example);

    int updateByPrimaryKeySelective(QUsers record);

    int updateByPrimaryKey(QUsers record);
}