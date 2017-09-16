package com.qm.backend.service;

import com.qm.backend.pojo.SysBreedTypeInfo;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysBreedTypeInfoService
{
    String save(SessionVO sessionVO, SysBreedTypeInfo info);

    String remove(SessionVO sessionVO, SysBreedTypeInfo info);

    String update(SessionVO sessionVO, SysBreedTypeInfo info);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysBreedTypeInfo info);
}
