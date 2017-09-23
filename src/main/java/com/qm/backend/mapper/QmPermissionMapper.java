package com.qm.backend.mapper;

import com.qm.backend.pojo.QmPermission;
import com.qm.backend.pojo.QmPermissionExample;
import com.qm.backend.pojo.QmPermissionRe;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QmPermissionMapper
{
    long countByExample(QmPermissionExample example);

    int deleteByExample(QmPermissionExample example);

    int deleteByPrimaryKey(String qmPermissionId);

    int insert(QmPermission record);

    int insertSelective(QmPermission record);

    List<QmPermission> selectByExample(QmPermissionExample example);

    QmPermission selectByPrimaryKey(String qmPermissionId);

    int updateByExampleSelective(@Param("record") QmPermission record, @Param("example") QmPermissionExample example);

    int updateByExample(@Param("record") QmPermission record, @Param("example") QmPermissionExample example);

    int updateByPrimaryKeySelective(QmPermission record);

    int updateByPrimaryKey(QmPermission record);

    int countPermission(@Param("permissionId") String qmPermissionId);

    int deletePermissionRe(@Param("permissionId") String qmPermissionId);

    List<QmPermissionRe> listPermission(@Param("permissionId") String qmPermissionId);
}