package com.qm.backend.service;

import com.qm.backend.pojo.InterfaceType;
import com.qm.backend.vo.SessionVO;

public interface InterfaceTypeService
{
    String save(SessionVO sessionVO, InterfaceType type);

    String remove(SessionVO sessionVO, InterfaceType type);

    String update(SessionVO sessionVO, InterfaceType type);

    String tree(SessionVO sessionVO);
}
