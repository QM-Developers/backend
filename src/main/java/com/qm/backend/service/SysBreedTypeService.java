package com.qm.backend.service;

import com.qm.backend.pojo.SysBreedType;
import com.qm.backend.vo.PageVO;
import com.qm.backend.vo.SessionVO;

public interface SysBreedTypeService
{
    String save(SessionVO sessionVO, SysBreedType breedType);

    String remove(SessionVO sessionVO, SysBreedType breedType);

    String update(SessionVO sessionVO, SysBreedType breedType);

    String list(SessionVO sessionVO, PageVO pageVO);

    String get(SessionVO sessionVO, SysBreedType breedType);
}
