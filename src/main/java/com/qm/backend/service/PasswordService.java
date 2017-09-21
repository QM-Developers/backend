package com.qm.backend.service;

import com.qm.backend.pojo.SysUser;
import com.qm.backend.vo.SessionVO;

public interface PasswordService
{
    String update(SessionVO sessionVO, SysUser user);
}
