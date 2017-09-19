package com.qm.backend.service;

import com.qm.backend.pojo.SysRole;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysRoleService
{
    String save(SessionVO sessionVO, SysRole role);

    String remove(SessionVO sessionVO, SysRole role);

    String update(SessionVO sessionVO, SysRole role);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysRole role);

    String updatePermission(SessionVO sessionVO, SysRole role);;
}
