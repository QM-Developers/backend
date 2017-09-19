package com.qm.backend.service;

import com.qm.backend.pojo.SysUser;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysUserService
{
    String save(SessionVO sessionVO, SysUser user);

    String update(SessionVO sessionVO, SysUser user);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysUser user);

    String updateRole(SessionVO sessionVO, SysUser user);

    String remove(SessionVO sessionVO, SysUser user);
}
