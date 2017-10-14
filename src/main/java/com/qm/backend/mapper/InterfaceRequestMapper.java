package com.qm.backend.mapper;

import com.qm.backend.pojo.InterfaceRequest;
import com.qm.backend.pojo.InterfaceRequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRequestMapper {
    long countByExample(InterfaceRequestExample example);

    int deleteByExample(InterfaceRequestExample example);

    int deleteByPrimaryKey(String requestId);

    int insert(InterfaceRequest record);

    int insertSelective(InterfaceRequest record);

    List<InterfaceRequest> selectByExample(InterfaceRequestExample example);

    InterfaceRequest selectByPrimaryKey(String requestId);

    int updateByExampleSelective(@Param("record") InterfaceRequest record, @Param("example") InterfaceRequestExample example);

    int updateByExample(@Param("record") InterfaceRequest record, @Param("example") InterfaceRequestExample example);

    int updateByPrimaryKeySelective(InterfaceRequest record);

    int updateByPrimaryKey(InterfaceRequest record);
}