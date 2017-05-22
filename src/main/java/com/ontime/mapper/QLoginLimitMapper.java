package com.ontime.mapper;

import com.ontime.pojo.QLoginLimit;
import com.ontime.pojo.QLoginLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repositorypublic interface QLoginLimitMapper {
    int countByExample(QLoginLimitExample example);

    int deleteByExample(QLoginLimitExample example);

    int deleteByPrimaryKey(Integer limitId);

    int insert(QLoginLimit record);

    int insertSelective(QLoginLimit record);

    List<QLoginLimit> selectByExample(QLoginLimitExample example);

    QLoginLimit selectByPrimaryKey(Integer limitId);

    int updateByExampleSelective(@Param("record") QLoginLimit record, @Param("example") QLoginLimitExample example);

    int updateByExample(@Param("record") QLoginLimit record, @Param("example") QLoginLimitExample example);

    int updateByPrimaryKeySelective(QLoginLimit record);

    int updateByPrimaryKey(QLoginLimit record);
}
