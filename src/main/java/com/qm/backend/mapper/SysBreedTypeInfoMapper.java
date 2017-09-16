package com.qm.backend.mapper;

import com.qm.backend.pojo.SysBreedTypeInfo;
import com.qm.backend.pojo.SysBreedTypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysBreedTypeInfoMapper {
    long countByExample(SysBreedTypeInfoExample example);

    int deleteByExample(SysBreedTypeInfoExample example);

    int deleteByPrimaryKey(String infoId);

    int insert(SysBreedTypeInfo record);

    int insertSelective(SysBreedTypeInfo record);

    List<SysBreedTypeInfo> selectByExample(SysBreedTypeInfoExample example);

    SysBreedTypeInfo selectByPrimaryKey(String infoId);

    int updateByExampleSelective(@Param("record") SysBreedTypeInfo record, @Param("example") SysBreedTypeInfoExample example);

    int updateByExample(@Param("record") SysBreedTypeInfo record, @Param("example") SysBreedTypeInfoExample example);

    int updateByPrimaryKeySelective(SysBreedTypeInfo record);

    int updateByPrimaryKey(SysBreedTypeInfo record);
}