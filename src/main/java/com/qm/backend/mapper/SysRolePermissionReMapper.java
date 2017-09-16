package com.qm.backend.mapper;

import com.qm.backend.pojo.SysRolePermissionRe;
import com.qm.backend.pojo.SysRolePermissionReExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePermissionReMapper {
    long countByExample(SysRolePermissionReExample example);

    int deleteByExample(SysRolePermissionReExample example);

    int insert(SysRolePermissionRe record);

    int insertSelective(SysRolePermissionRe record);

    List<SysRolePermissionRe> selectByExample(SysRolePermissionReExample example);

    int updateByExampleSelective(@Param("record") SysRolePermissionRe record, @Param("example") SysRolePermissionReExample example);

    int updateByExample(@Param("record") SysRolePermissionRe record, @Param("example") SysRolePermissionReExample example);
}