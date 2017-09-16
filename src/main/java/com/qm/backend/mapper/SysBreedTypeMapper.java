package com.qm.backend.mapper;

import com.qm.backend.pojo.SysBreedType;
import com.qm.backend.pojo.SysBreedTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysBreedTypeMapper {
    long countByExample(SysBreedTypeExample example);

    int deleteByExample(SysBreedTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(SysBreedType record);

    int insertSelective(SysBreedType record);

    List<SysBreedType> selectByExample(SysBreedTypeExample example);

    SysBreedType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") SysBreedType record, @Param("example") SysBreedTypeExample example);

    int updateByExample(@Param("record") SysBreedType record, @Param("example") SysBreedTypeExample example);

    int updateByPrimaryKeySelective(SysBreedType record);

    int updateByPrimaryKey(SysBreedType record);
}