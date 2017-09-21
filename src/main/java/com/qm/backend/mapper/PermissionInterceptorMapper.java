package com.qm.backend.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionInterceptorMapper
{
    int countPermission(@Param("userId") String userId, @Param("url") String url);
}
