package com.qm.backend.mapper;

import com.qm.backend.pojo.SysBreedTypeSelect;
import com.qm.backend.pojo.SysBreedTypeSelectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysBreedTypeSelectMapper {
    long countByExample(SysBreedTypeSelectExample example);

    int deleteByExample(SysBreedTypeSelectExample example);

    int deleteByPrimaryKey(String selectId);

    int insert(SysBreedTypeSelect record);

    int insertSelective(SysBreedTypeSelect record);

    List<SysBreedTypeSelect> selectByExample(SysBreedTypeSelectExample example);

    SysBreedTypeSelect selectByPrimaryKey(String selectId);

    int updateByExampleSelective(@Param("record") SysBreedTypeSelect record, @Param("example") SysBreedTypeSelectExample example);

    int updateByExample(@Param("record") SysBreedTypeSelect record, @Param("example") SysBreedTypeSelectExample example);

    int updateByPrimaryKeySelective(SysBreedTypeSelect record);

    int updateByPrimaryKey(SysBreedTypeSelect record);
}