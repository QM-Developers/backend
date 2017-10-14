package com.qm.backend.mapper;

import com.qm.backend.pojo.InterfaceResponse;
import com.qm.backend.pojo.InterfaceResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceResponseMapper {
    long countByExample(InterfaceResponseExample example);

    int deleteByExample(InterfaceResponseExample example);

    int deleteByPrimaryKey(String responseId);

    int insert(InterfaceResponse record);

    int insertSelective(InterfaceResponse record);

    List<InterfaceResponse> selectByExample(InterfaceResponseExample example);

    InterfaceResponse selectByPrimaryKey(String responseId);

    int updateByExampleSelective(@Param("record") InterfaceResponse record, @Param("example") InterfaceResponseExample example);

    int updateByExample(@Param("record") InterfaceResponse record, @Param("example") InterfaceResponseExample example);

    int updateByPrimaryKeySelective(InterfaceResponse record);

    int updateByPrimaryKey(InterfaceResponse record);
}