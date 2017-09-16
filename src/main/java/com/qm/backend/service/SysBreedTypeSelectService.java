package com.qm.backend.service;

import com.qm.backend.pojo.SysBreedTypeSelect;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysBreedTypeSelectService
{
    String save(SessionVO sessionVO, SysBreedTypeSelect select);

    String remove(SessionVO sessionVO, SysBreedTypeSelect select);

    String update(SessionVO sessionVO, SysBreedTypeSelect select);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysBreedTypeSelect select);
}
