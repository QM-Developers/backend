package com.qm.backend.mapper;

import com.qm.backend.pojo.InterfaceType;
import com.qm.backend.pojo.InterfaceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceTypeMapper {
    long countByExample(InterfaceTypeExample example);

    int deleteByExample(InterfaceTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(InterfaceType record);

    int insertSelective(InterfaceType record);

    List<InterfaceType> selectByExample(InterfaceTypeExample example);

    InterfaceType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") InterfaceType record, @Param("example") InterfaceTypeExample example);

    int updateByExample(@Param("record") InterfaceType record, @Param("example") InterfaceTypeExample example);

    int updateByPrimaryKeySelective(InterfaceType record);

    int updateByPrimaryKey(InterfaceType record);
}