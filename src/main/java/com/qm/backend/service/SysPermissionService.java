package com.qm.backend.service;

import com.qm.backend.pojo.SysPermission;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysPermissionService
{
    String save(SessionVO sessionVO, SysPermission permission);

    String remove(SessionVO sessionVO, SysPermission permission);

    String update(SessionVO sessionVO, SysPermission permission);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysPermission permission);
}
