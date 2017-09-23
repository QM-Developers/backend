package com.qm.backend.service;

import com.qm.backend.pojo.QmPermission;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface QmPermissionService
{
    String save(SessionVO sessionVO, QmPermission permission);

    String remove(SessionVO sessionVO, QmPermission permission);

    String update(SessionVO sessionVO, QmPermission permission);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, QmPermission permission);

    String updatePermission(SessionVO sessionVO, QmPermission permission);
}
