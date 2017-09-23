package com.qm.backend.mapper;

import com.qm.backend.pojo.QmPermissionRe;
import com.qm.backend.pojo.QmPermissionReExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QmPermissionReMapper {
    long countByExample(QmPermissionReExample example);

    int deleteByExample(QmPermissionReExample example);

    int insert(QmPermissionRe record);

    int insertSelective(QmPermissionRe record);

    List<QmPermissionRe> selectByExample(QmPermissionReExample example);

    int updateByExampleSelective(@Param("record") QmPermissionRe record, @Param("example") QmPermissionReExample example);

    int updateByExample(@Param("record") QmPermissionRe record, @Param("example") QmPermissionReExample example);
}