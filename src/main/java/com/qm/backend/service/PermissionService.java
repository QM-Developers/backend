package com.qm.backend.service;


import com.qm.backend.pojo.Permission;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface PermissionService
{
    String save(SessionVO sessionVO, Permission permission);

    String remove(SessionVO sessionVO, Permission permission);

    String update(SessionVO sessionVO, Permission permission);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, Permission permission);

    String tree(SessionVO sessionVO);
}
