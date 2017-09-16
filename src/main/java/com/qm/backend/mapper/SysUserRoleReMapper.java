package com.qm.backend.mapper;

import com.qm.backend.pojo.SysUserRoleRe;
import com.qm.backend.pojo.SysUserRoleReExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleReMapper {
    long countByExample(SysUserRoleReExample example);

    int deleteByExample(SysUserRoleReExample example);

    int insert(SysUserRoleRe record);

    int insertSelective(SysUserRoleRe record);

    List<SysUserRoleRe> selectByExample(SysUserRoleReExample example);

    int updateByExampleSelective(@Param("record") SysUserRoleRe record, @Param("example") SysUserRoleReExample example);

    int updateByExample(@Param("record") SysUserRoleRe record, @Param("example") SysUserRoleReExample example);
}