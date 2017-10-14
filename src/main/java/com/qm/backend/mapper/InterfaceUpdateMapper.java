package com.qm.backend.mapper;

import com.qm.backend.pojo.InterfaceUpdate;
import com.qm.backend.pojo.InterfaceUpdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceUpdateMapper {
    long countByExample(InterfaceUpdateExample example);

    int deleteByExample(InterfaceUpdateExample example);

    int deleteByPrimaryKey(String updateId);

    int insert(InterfaceUpdate record);

    int insertSelective(InterfaceUpdate record);

    List<InterfaceUpdate> selectByExample(InterfaceUpdateExample example);

    InterfaceUpdate selectByPrimaryKey(String updateId);

    int updateByExampleSelective(@Param("record") InterfaceUpdate record, @Param("example") InterfaceUpdateExample example);

    int updateByExample(@Param("record") InterfaceUpdate record, @Param("example") InterfaceUpdateExample example);

    int updateByPrimaryKeySelective(InterfaceUpdate record);

    int updateByPrimaryKey(InterfaceUpdate record);
}