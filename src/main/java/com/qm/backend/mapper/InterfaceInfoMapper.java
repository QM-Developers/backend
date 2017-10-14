package com.qm.backend.mapper;

import com.qm.backend.pojo.InterfaceInfo;
import com.qm.backend.pojo.InterfaceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceInfoMapper {
    long countByExample(InterfaceInfoExample example);

    int deleteByExample(InterfaceInfoExample example);

    int deleteByPrimaryKey(String infoId);

    int insert(InterfaceInfo record);

    int insertSelective(InterfaceInfo record);

    List<InterfaceInfo> selectByExample(InterfaceInfoExample example);

    InterfaceInfo selectByPrimaryKey(String infoId);

    int updateByExampleSelective(@Param("record") InterfaceInfo record, @Param("example") InterfaceInfoExample example);

    int updateByExample(@Param("record") InterfaceInfo record, @Param("example") InterfaceInfoExample example);

    int updateByPrimaryKeySelective(InterfaceInfo record);

    int updateByPrimaryKey(InterfaceInfo record);
}